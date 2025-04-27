ALTER TABLE cco_user
    ADD COLUMN join_date DATE DEFAULT NOW();

UPDATE cco_user
SET join_date = NOW()
WHERE join_date IS NULL;