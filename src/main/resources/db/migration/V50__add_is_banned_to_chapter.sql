DO
$$
    BEGIN
        IF NOT EXISTS (SELECT 1
                       FROM information_schema.columns
                       WHERE table_name = 'chapter'
                         AND column_name = 'is_banned') THEN
            ALTER TABLE chapter
                ADD COLUMN is_banned BOOLEAN DEFAULT FALSE;
        END IF;
    END
$$;

UPDATE chapter
SET is_banned = FALSE
WHERE is_banned IS NULL;
