SELECT T1.GRADE, T1.ID, T1.EMAIL
FROM (
    SELECT
        CASE
            WHEN (
                EXISTS (
                    SELECT 1
                    FROM SKILLCODES
                    WHERE SKILL_CODE & CODE = CODE AND CATEGORY = 'Front End'
                ) 
                AND
                EXISTS (
                    SELECT 1
                    FROM SKILLCODES
                    WHERE SKILL_CODE & CODE = CODE AND NAME = 'Python'
                )
            )   THEN 'A'
            WHEN (
                EXISTS (
                    SELECT 1
                    FROM SKILLCODES
                    WHERE SKILL_CODE & CODE = CODE AND NAME = 'C#'
                )
            )   THEN 'B'
            WHEN (
                EXISTS (
                    SELECT 1
                    FROM SKILLCODES
                    WHERE SKILL_CODE & CODE = CODE AND CATEGORY = 'Front End'
                )
            )   THEN 'C'
        END AS GRADE
    ,   ID
    ,   EMAIL
    FROM DEVELOPERS
    ORDER BY GRADE, ID
) T1
WHERE T1.GRADE IS NOT NULL