/**
 * 省市区三级联动
 * @Author Xushd
 * @Since 2017-02-05 00:24:22
 * @desc 省(name=prov) 市(name=city) 区(name=area)
 *
 */
layui.use(["areadata","form"],function () {

    var $ =layui.jquery,
        p = layui.areadata.area_array,//省
        c = layui.areadata.sub_array,//市
        q = layui.areadata.sub_arr,//区
        form=layui.form(),
        m = document.getElementsByName('prov')[0],
        n = document.getElementsByName('city')[0],
        o = document.getElementsByName('area')[0];

    var obj = {
        init:function (d) {
            if(d.length==4){
                $(o).parent().hide();

            }
            var _p = d.substring(0,2);
            for (e = 0; e < p.length; e++) {
                if (p[e] == undefined) {
                    continue;
                }
                m.options[e] = new Option(p[e], e);
                if (_p == e) {
                    m.options[e].selected = true;
                }
            }
            n.options[0] = new Option("请选择市 ", 0);
            o.options[0] = new Option("请选择县/区 ", 0);
            if(d.length>2){
                obj.provChange(d);
            }
            if(d.length>4){
                obj.changeCity(d);
            }
            form.render('select');
        },
        provChange:function(v){
            obj.removeOptions(n);
            var _c= 1,f= v.substring(0,2),t= v.substring(0,4);
            n.options[0] = new Option("请选择市 ", 0);
            if (c[f] != undefined) {
                for (b = 0; b < c[f].length; b++) {
                    if (c[f][b] == undefined) { continue }
                    if ( (f != 71) && (f != 81) && (f != 82)) { if ((b % 100) == 0) { continue } }
                    n.options[_c] = new Option(c[f][b], b);
                    if (t == b) {
                        n.options[_c].selected = true;
                    }
                    _c++;
                }
            }
            obj.removeOptions(o);
            o.options[0] = new Option("请选择县/区 ", 0);
            if (f == 11 || f == 12 || f == 31 || f == 71 || f == 50 || f == 81 || f == 82) {
                $(o).parent().hide();

            }
            else {
                $(o).parent().show();

            }
            form.render('select');

        },
        changeCity:function(v){
            obj.removeOptions(o);
            o.options[0] = new Option("请选择县/区 ", 0);
            var t = v.substring(0, 2),f= v.substring(0,4);
            if (v==0||t == 11 || t == 12 || t == 31 || t == 71 || t == 50 || t == 81 || t == 82){

            }else{
                var _d = q[f],_c=1;
                for (var i = f * 100; i < _d.length; i++) {
                    if (_d[i] == undefined) continue;
                    o.options[_c] = new Option(_d[i], i);
                    if (v == i) {
                        o.options[_c].selected = true;
                    }
                    _c++;
                }
            }
            form.render('select');
        },
        removeOptions:function(c){
            if ((c != undefined) && (c.options != undefined)) {
                var a = c.options.length;
                for (var b = 0; b < a; b++) {
                    c.options[0] = null;
                }
            }
        }
    }
    var code = $("#code").val();
    obj.init(code||"0");
    form.on('select(prov)', function(data){
        obj.provChange(data.value);
    });
    form.on('select(city)', function(data){
        obj.changeCity(data.value);
    });
    
});

