package com.maizhong.rest.aspect;

import com.maizhong.pojo.TbCar;
import com.maizhong.rest.service.DataSyncService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


/**
 * 只适用于tbcar
 *       需求 solr库更新与删除
 *
 *
 *      类似sql触发器
 *      未使用
 *
 *
 * Created by YangF on 2017/4/5.
 */
@Component
@Aspect
public class DataAspect {

    @Resource
    private DataSyncService dataSyncService;


    /**
     * 环绕通知
     *         监听 tbCar mapper类
     *
     *         业务需求变更   tbcar  issale状态为1时才需要更新到solr库
     * @param pjp
     * @return
     * @throws Throwable
     */
//    @Around("execution(* com.maizhong.mapper.TbCarMapper.*(..))")
    public Object carSyncToSolr(ProceedingJoinPoint pjp) throws Throwable{


        Object object = pjp.proceed();//执行该方法

        try {
            if (!(object instanceof List)&&!(object instanceof TbCar)&&Long.parseLong(object.toString())>0){
                //获取方法名称
                Signature signature = pjp.getSignature();
                MethodSignature methodSignature = (MethodSignature)signature;
                String methodName = methodSignature.getMethod().getName();

                //定位方法   上次判断已经可以定位为这三个方法
//                if (methodName.contains("insert")||methodName.contains("update")||methodName.contains("delete")){
                    //数据填充
                    Long delId = null;
                    Long insertId = null;
                    Object[] args = pjp.getArgs();

                // 数据填充  不包含插入  与 不包含 删除
                if (!methodName.contains("insert")){
                    for (Object arg:args) {
                        if (arg instanceof TbCar){
                            delId = ((TbCar)arg).getId();
                            break;
                        }else if (arg instanceof Long){
                            insertId = (Long)arg;
                            break;
                        }
                    }
                }
                if (!methodName.contains("delete")){
                    for (Object arg:args) {
                        if (arg instanceof TbCar){
                            insertId = ((TbCar)arg).getId();
                            break;
                        }
                    }
                }
                syncData(delId,insertId);
//                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return object;
    }


    private void syncData(final Long delid,final Long insertId){
        if (insertId==null&&delid==null){
            return;
        }
        new Thread("solr数据同步线程"){
            @Override
            public void run(){
                try {
                    dataSyncService.dataSyncOfSingle(delid,insertId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        System.out.println("id "+insertId+"   汽车数据正在同步");
    }

}
