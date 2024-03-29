SELECT
    A.CAR_ID,
    A.CAR_TYPE,
    ROUND(A.DAILY_FEE * 30 * (1 - B.DISCOUNT_RATE/100)) AS FEE
FROM
    CAR_RENTAL_COMPANY_CAR A
INNER JOIN
   CAR_RENTAL_COMPANY_DISCOUNT_PLAN B 
ON
    A.CAR_TYPE = B.CAR_TYPE
WHERE
    A.CAR_TYPE IN ('세단','SUV') AND
    B.DURATION_TYPE = '30일 이상' AND
    A.CAR_ID NOT IN (
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-11-30'
    )
HAVING 
    FEE >= 500000 AND FEE < 2000000
ORDER BY
    FEE DESC, 
    A.CAR_TYPE ASC, 
    A.CAR_ID DESC