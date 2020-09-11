删除表中重复字段，下面是根据air_sk_hour_statement_copy表的 site_code和query_time两个字段去重
===
    DELETE
    FROM
	`air_sk_hour_statement_copy`
    WHERE
	(site_code, query_time) IN (
		SELECT
			t.site_code,
			t.query_time
		FROM
			(
				SELECT
					site_code,
					query_time
				FROM
					`air_sk_hour_statement_copy`
				GROUP BY
					site_code,
					query_time
				HAVING
					COUNT(1) > 1
			) t
	)
    AND id NOT IN (
	SELECT
		dt.minid
	FROM
		(
			SELECT
				MIN(id) AS minid
			FROM
				`air_sk_hour_statement_copy`
			GROUP BY
				site_code,
					query_time
			HAVING
				COUNT(1) > 1
		) dt
    )
 
分组查询最近一条记录，主键是自增id，根据site_id分组，效率还行
===
    SELECT
    	* 
    FROM
    	`air_data_day_original` 
    WHERE
    	id IN (
    	SELECT
    		id 
    	FROM
    	( SELECT site_id, max( report_time ), max( id ) AS id FROM `air_data_day_original` WHERE data_type = 1 GROUP BY site_id ) t 
    	)
    	
分组查询最近一条记录，主键不是自增id，根据site_id分组，效率不高
===
    SELECT a.* FROM air_data_day_original a,( SELECT max( report_time ) AS report_time, site_id FROM air_data_day_original GROUP BY site_id ) AS tmp 
    WHERE
        tmp.report_time = a.report_time 
        AND tmp.site_id = a.site_id 
        AND a.data_type = 1