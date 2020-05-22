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
				air_sk_hour_statement_copy
			GROUP BY
				site_code,
					query_time
			HAVING
				COUNT(1) > 1
		) dt
    )
 