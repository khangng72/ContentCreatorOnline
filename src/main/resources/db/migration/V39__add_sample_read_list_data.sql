-- khangnguyn07022002@gmail.com

INSERT INTO read_list (read_list_id, read_list_title, read_list_description, user_id)
VALUES ('d1f63b28-0cf4-4ae1-85c6-2a5d6e8b61db', 'Favorites', 'A list of my favorite stories',
        '061460f1-45fd-40a8-b243-5da3f0f35523'),
       ('a81c5d3f-50aa-44e2-9d37-f6c4bc77efc6', 'To Read Later', 'Stories I plan to read later',
        '061460f1-45fd-40a8-b243-5da3f0f35523'),
       ('f43b52ce-8383-4d18-8d1e-8d934ec118b0', 'Completed Reads', 'Stories I have completed reading',
        '061460f1-45fd-40a8-b243-5da3f0f35523'),
       ('e8b3bfe4-d9d8-4427-9fa6-553f154aa51a', 'Horror Picks', 'Top horror stories I enjoy',
        '061460f1-45fd-40a8-b243-5da3f0f35523'),
       ('3d2781e2-f75d-4a3b-a048-46e67b37449f', 'Adventure Vault', 'Adventure stories worth rereading',
        '061460f1-45fd-40a8-b243-5da3f0f35523');

INSERT INTO contains (read_list_id, story_id)
VALUES
-- Favorites (7 stories)
('d1f63b28-0cf4-4ae1-85c6-2a5d6e8b61db', 'd30eb63f-655a-47db-ad8d-52d81a3e552f'),
('d1f63b28-0cf4-4ae1-85c6-2a5d6e8b61db', 'a7b8c9d0-e1f2-3456-7890-abcdef123456'),
('d1f63b28-0cf4-4ae1-85c6-2a5d6e8b61db', 'db14a441-e4b4-4d72-9c72-e9f23fae0c68'),
('d1f63b28-0cf4-4ae1-85c6-2a5d6e8b61db', 'e7c4f9a0-5d8f-4bdb-bce5-123456789abc'),
('d1f63b28-0cf4-4ae1-85c6-2a5d6e8b61db', 'b8a1fbe3-2f92-4971-a097-bd01d42b9140'),
('d1f63b28-0cf4-4ae1-85c6-2a5d6e8b61db', 'c1b05e6d-6c96-4744-92ca-65ac0409250d'),
('d1f63b28-0cf4-4ae1-85c6-2a5d6e8b61db', '8b3a1c2d-512e-4d62-9d04-8f6f3cf33c21'),

-- To Read Later (10 stories)
('a81c5d3f-50aa-44e2-9d37-f6c4bc77efc6', 'd7eecb7c-8e92-4f2f-8d40-3b58c537c501'),
('a81c5d3f-50aa-44e2-9d37-f6c4bc77efc6', 'a3e41d5d-51f1-4e3a-8d9a-4d0e9e8c7c05'),
('a81c5d3f-50aa-44e2-9d37-f6c4bc77efc6', 'f8d3a2e7-0b5e-4cf7-9c9e-4d6f6f35e0aa'),
('a81c5d3f-50aa-44e2-9d37-f6c4bc77efc6', 'e3a5c7b8-1c3d-4f78-9421-8f4e1234abcd'),
('a81c5d3f-50aa-44e2-9d37-f6c4bc77efc6', 'd8f6c2b7-5e3f-49c8-bc58-54d5b77b1234'),
('a81c5d3f-50aa-44e2-9d37-f6c4bc77efc6', 'c4b3f8e4-2453-4f5b-9f85-6b839bb7e453'),
('a81c5d3f-50aa-44e2-9d37-f6c4bc77efc6', '2a9f7b84-5cb4-4b45-a951-6e432fcdce42'),
('a81c5d3f-50aa-44e2-9d37-f6c4bc77efc6', '7b8d9d70-bf6f-48ac-96f2-33a330c6fae2'),
('a81c5d3f-50aa-44e2-9d37-f6c4bc77efc6', '3f9a690b-94d7-4c7b-a243-907d0a254a11'),
('a81c5d3f-50aa-44e2-9d37-f6c4bc77efc6', 'a1b2c3d4-5678-9101-1121-314151617181'),

-- Completed Reads (6 stories)
('f43b52ce-8383-4d18-8d1e-8d934ec118b0', 'd30eb63f-655a-47db-ad8d-52d81a3e552f'),
('f43b52ce-8383-4d18-8d1e-8d934ec118b0', 'db14a441-e4b4-4d72-9c72-e9f23fae0c68'),
('f43b52ce-8383-4d18-8d1e-8d934ec118b0', 'c1b05e6d-6c96-4744-92ca-65ac0409250d'),
('f43b52ce-8383-4d18-8d1e-8d934ec118b0', 'a3e41d5d-51f1-4e3a-8d9a-4d0e9e8c7c05'),
('f43b52ce-8383-4d18-8d1e-8d934ec118b0', '2a9f7b84-5cb4-4b45-a951-6e432fcdce42'),
('f43b52ce-8383-4d18-8d1e-8d934ec118b0', '7b8d9d70-bf6f-48ac-96f2-33a330c6fae2'),

-- Horror Picks (5 stories)
('e8b3bfe4-d9d8-4427-9fa6-553f154aa51a', 'e7c4f9a0-5d8f-4bdb-bce5-123456789abc'),
('e8b3bfe4-d9d8-4427-9fa6-553f154aa51a', '8b3a1c2d-512e-4d62-9d04-8f6f3cf33c21'),
('e8b3bfe4-d9d8-4427-9fa6-553f154aa51a', 'd7eecb7c-8e92-4f2f-8d40-3b58c537c501'),
('e8b3bfe4-d9d8-4427-9fa6-553f154aa51a', 'f8d3a2e7-0b5e-4cf7-9c9e-4d6f6f35e0aa'),
('e8b3bfe4-d9d8-4427-9fa6-553f154aa51a', '3f9a690b-94d7-4c7b-a243-907d0a254a11'),

-- Adventure Vault (9 stories)
('3d2781e2-f75d-4a3b-a048-46e67b37449f', 'a7b8c9d0-e1f2-3456-7890-abcdef123456'),
('3d2781e2-f75d-4a3b-a048-46e67b37449f', 'db14a441-e4b4-4d72-9c72-e9f23fae0c68'),
('3d2781e2-f75d-4a3b-a048-46e67b37449f', 'b8a1fbe3-2f92-4971-a097-bd01d42b9140'),
('3d2781e2-f75d-4a3b-a048-46e67b37449f', 'e3a5c7b8-1c3d-4f78-9421-8f4e1234abcd'),
('3d2781e2-f75d-4a3b-a048-46e67b37449f', 'd8f6c2b7-5e3f-49c8-bc58-54d5b77b1234'),
('3d2781e2-f75d-4a3b-a048-46e67b37449f', 'c4b3f8e4-2453-4f5b-9f85-6b839bb7e453'),
('3d2781e2-f75d-4a3b-a048-46e67b37449f', 'a1b2c3d4-5678-9101-1121-314151617181'),
('3d2781e2-f75d-4a3b-a048-46e67b37449f', 'd30eb63f-655a-47db-ad8d-52d81a3e552f'),
('3d2781e2-f75d-4a3b-a048-46e67b37449f', 'a3e41d5d-51f1-4e3a-8d9a-4d0e9e8c7c05');

