/*
 * APICloud JavaScript Library
 * Copyright (c) 2014 apicloud.com
 */
(function(window){
    var u = {};
    
    var db;
    var dbName = 'maizhongcar';
    var dbPath = 'fs://maizhongcar.db';
    

    // 引入db模块
    u.init = function(){
        if (db) {
            return;
        }
        db = api.require('db');
    };

    // 创建数据库及相关的数据表结构
    u.open = function() {
        u.init();
        var ret = db.openDatabaseSync({
            name: dbName,
            path: dbPath
        });
        
        if (ret.status) {
        	
        	var sql1 = 'CREATE TABLE IF NOT EXISTS provice (name VARCHAR(32), proviceId INT,initial CHAR(1))';
        	var sql2 = 'CREATE TABLE IF NOT EXISTS city (name VARCHAR(32), proviceId INT,id INT);';
        	var sql3 = 'CREATE TABLE IF NOT EXISTS line (name VARCHAR(32), lineId INT);';
        	var sql4 = 'CREATE TABLE IF NOT EXISTS site (name VARCHAR(32), lineId INT, siteId INT);';
        	
        	db.executeSql({
			    name: dbName,
			    sql: sql1
			}, function(ret, err){
			    if(ret.status){
			       console.log('执行 provice create SQL成功'+JSON.stringify(ret));
			    }else{
			       console.log(err.msg);
			    }
			});     
			db.executeSql({
			    name: dbName,
			    sql: sql2
			}, function(ret, err){
			    if(ret.status){
			       console.log('执行 city create SQL成功'+JSON.stringify(ret));
			    }else{
			       console.log(err.msg);
			    }
			});     
			db.executeSql({
			    name: dbName,
			    sql: sql3
			}, function(ret, err){
			    if(ret.status){
			       console.log('执行 line create SQL成功'+JSON.stringify(ret));
			    }else{
			       console.log(err.msg);
			    }
			});     
			db.executeSql({
			    name: dbName,
			    sql: sql4
			}, function(ret, err){
			    if(ret.status){
			       console.log('执行 site create SQL成功'+JSON.stringify(ret));
			    }else{
			       console.log(err.msg);
			    }
			});     
			
        }
    }

	/**
	 * 查询本地数据库省份
	 */
	u.selectProvice = function(){
		u.init();
		var sql = 'SELECT * FROM provice';
		return db.selectSqlSync({
            name: dbName,
            sql: sql
        });
	}
	/**
	 * 插入本地数据库省份
	 * @param {Object} arry
	 */
	u.insertProvice = function(arry){
		
		u.init();		
		var ret = db.executeSqlSync({
			name:dbName,
			sql:'DELETE FROM provice'
		})
		
		
		var sql = [];
		$api.each(arry,function(index,obj){			
			sql.push('("' + obj.provId + '","' + obj.provName +'","' + obj.initial + '")')
		});		
		
        return db.executeSqlSync({
            name: dbName,
            sql: 'INSERT INTO provice (proviceId,name,initial) VALUES'+sql.join(',')    
        });
	}
   
   
   
   /**
	 * 查询本地数据库城市
	 */
	u.selectCity = function(){
		u.init();
		var sql = 'SELECT * FROM city';
		return db.selectSqlSync({
            name: dbName,
            sql: sql
        });
	}
	/**
	 * 通过城市名称获取城市信息
	 * @param {Object} cityName
	 */
	u.selectCityIdLikeCityName = function(cityName){
		u.init();
		var sql = 'SELECT * FROM city WHERE name = "'+cityName+'"';
		return db.selectSqlSync({
            name: dbName,
            sql: sql
        });
	}
	
	/**
	 * 本地地铁线路是否为空
	 */
	u.countLine = function(){
		u.init();
		var sql = 'SELECT count(*) AS count FROM line';
		var res = db.selectSqlSync({
			name: dbName,
            sql: sql
		});
		
		if(res.status){
			return Number(res.data[0].count);
		}
		return 0;
	}
	/**
	 * 本地地铁站是否为空
	 */
	u.countSite = function(){
		u.init();
		var sql = 'SELECT count(*) AS count FROM site';
		var res = db.selectSqlSync({
			name: dbName,
            sql: sql
		});
		
		if(res.status){
			return Number(res.data[0].count);
		}
		return 0;
	}
	/**
	 * 本地数据库插入地铁线路
	 * @param {Object} arry
	 */
	u.insertLine = function(arry){
		u.init();
		var ret = db.executeSqlSync({
			name:dbName,
			sql:'DELETE FROM line'
		})
		var sql = [];
		$api.each(arry,function(index,obj){			
			sql.push('("' + obj.id + '","' + obj.name +'")')
		});		
		
        return db.executeSqlSync({
            name: dbName,
            sql: 'INSERT INTO line (lineId,name) VALUES'+sql.join(',')    
        });
	}
	/**
	 * 获取地铁线路
	 */
	u.selectLine = function(){
				
		u.init();
		var sql = 'SELECT * FROM line';
		return db.selectSqlSync({
            name: dbName,
            sql: sql
        });
		
	}
	
	/**
	 * 根据地铁线路获取地铁站
	 * @param {Object} lineId
	 */
	u.selectSiteByLineId = function(lineId){
		u.init();
		var sql = 'SELECT * FROM site WHERE lineId = "'+lineId+'"';
		return db.selectSqlSync({
			name:dbName,
			sql:sql
		})
	}
	/**
	 * 查询所有地铁站点
	 */
	u.selectSite = function(){
		u.init();
		var sql = 'SELECT * FROM site ';
		return db.selectSqlSync({
			name:dbName,
			sql:sql
		})
	}
	
	/**
	 * 本地数据库插入地铁站信息
	 * @param {Object} arry
	 */
	u.insertSite = function(arry){
		u.init();
		var ret = db.executeSqlSync({
			name:dbName,
			sql:'DELETE FROM site'
		})
		var sql = [];
		$api.each(arry,function(index,obj){				
			sql.push('("' + obj.id + '","' + obj.lineId +'","'+obj.name+'")')
		});		
		
        return db.executeSqlSync({
            name: dbName,
            sql: 'INSERT INTO site (siteId,lineId,name) VALUES'+sql.join(',')    
        });
	}
	
	/**
	 * 根据省份ID获取城市
	 * @param {Object} provId
	 */
	u.selectCityByProviceId = function(provId){
		u.init();
		var sql = 'SELECT * FROM city WHERE proviceId = "'+provId+'"';
		return db.selectSqlSync({
            name: dbName,
            sql: sql
        });
	}
	/**
	 * 根据城市ID获取城市名称
	 * @param {Object} cityId
	 */
	u.selectCityByCityId = function(cityId){
		u.init();
		var sql = 'SELECT id,name FROM city WHERE id = "'+cityId+'"';
		return db.selectSqlSync({
            name: dbName,
            sql: sql
        });
	}
	/**
	 * 插入本地数据库城市
	 * @param {Object} arry
	 */
	u.insertCity = function(arry){
		u.init();
		var ret = db.executeSqlSync({
			name:dbName,
			sql:'DELETE FROM city'
		})
		var sql = [];
		$api.each(arry,function(index,obj){			
			sql.push('("' + obj.id + '","' + obj.name +'","' + obj.prov + '")')
		});		
		
        return db.executeSqlSync({
            name: dbName,
            sql: 'INSERT INTO city (id,name,proviceId) VALUES'+sql.join(',')    
        });
	}
	/**
	 * 查询所有品牌
	 */
    u.selectBrandAll = function(){
   		u.init();
		var sql = 'SELECT * FROM brand';
		return db.selectSqlSync({
            name: dbName,
            sql: sql
        });
    }
    /**
     * 查询热门品牌
     */
	u.selectBrandHot = function(){
		u.init();
		var sql = 'SELECT * FROM brand WHERE hot = "1"';
		return db.selectSqlSync({
            name: dbName,
            sql: sql
        });
	}
	/**
	 * 插入本地品牌
	 * @param {Object} arry
	 */
    u.insertBrand = function(arry){
    	u.init();
    	var ret = db.executeSqlSync({
			name:dbName,
			sql:'DELETE FROM brand'
		})
		var sql = [];
		$api.each(arry,function(index,obj){			
			sql.push('("' + obj.id + '","' + obj.name +'","' + obj.img + '","'+obj.initial+'","'+obj.isHot+'")')
		});		
		
        return db.executeSqlSync({
            name: dbName,
            sql: 'INSERT INTO brand (id,name,img,initial,hot) VALUES'+sql.join(',')    
        });
    }
	u.clearBrand = function(){
		u.init();
		return db.executeSqlSync({
            name: dbName,
            sql: 'DELETE from brand'    
        });
	}
	/*end*/
    
    window.$db = u;

})(window);


