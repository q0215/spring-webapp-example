SELECT
    id,
    name,
    enabled,
    CASE role
        WHEN '1' THEN 'ROLE_ADMIN'
        WHEN '2' THEN 'ROLE_USER'
    END authority,
    TO_CHAR(registered, 'YYYY/MM/DD HH24:MI:SS') AS registered
FROM
    accounts
