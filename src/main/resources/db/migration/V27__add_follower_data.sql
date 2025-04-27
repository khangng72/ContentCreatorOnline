--"khangnguyn07022002@gmail.com"
INSERT INTO public.user_followers (user_id, follower_id)
VALUES ('061460f1-45fd-40a8-b243-5da3f0f35523', '063666bd-6ecb-440d-b560-dc306493fe59'),
       ('061460f1-45fd-40a8-b243-5da3f0f35523', '3df592a4-daa8-4819-863e-d4f7998ad0f3'),
       ('061460f1-45fd-40a8-b243-5da3f0f35523', '7826ee10-98d3-4cdc-96a6-2dfcdcb728d8'),
       ('061460f1-45fd-40a8-b243-5da3f0f35523', 'a8bcd7e3-d273-49c0-a226-259b02658c73'),
       ('061460f1-45fd-40a8-b243-5da3f0f35523', 'add7566f-c8c9-4932-b165-7ce6a465b18e'),
       ('061460f1-45fd-40a8-b243-5da3f0f35523', 'b5b8dbce-7d66-4399-868c-cde35c31c10a'),
       ('061460f1-45fd-40a8-b243-5da3f0f35523', 'd41ba763-57b5-4f8a-bdd2-2f3cc53b93a2'),
       ('061460f1-45fd-40a8-b243-5da3f0f35523', 'dab3e0c6-6b94-426e-8347-14a8fea8a42b'),
       ('061460f1-45fd-40a8-b243-5da3f0f35523', 'f6b24e76-2cd6-4881-86e9-ffadbba23720'),
       ('061460f1-45fd-40a8-b243-5da3f0f35523', 'fd81d17f-8ccb-4a65-a281-0a2d8ba25b2e');

-- "alice@example.com"
INSERT INTO public.user_followers (user_id, follower_id)
VALUES ('063666bd-6ecb-440d-b560-dc306493fe59', '7826ee10-98d3-4cdc-96a6-2dfcdcb728d8'),
       ('063666bd-6ecb-440d-b560-dc306493fe59', 'a8bcd7e3-d273-49c0-a226-259b02658c73'),
       ('063666bd-6ecb-440d-b560-dc306493fe59', 'add7566f-c8c9-4932-b165-7ce6a465b18e'),
       ('063666bd-6ecb-440d-b560-dc306493fe59', 'b5b8dbce-7d66-4399-868c-cde35c31c10a'),
       ('063666bd-6ecb-440d-b560-dc306493fe59', 'd41ba763-57b5-4f8a-bdd2-2f3cc53b93a2'),
       ('063666bd-6ecb-440d-b560-dc306493fe59', 'dab3e0c6-6b94-426e-8347-14a8fea8a42b');

-- "bob@example.com"
INSERT INTO public.user_followers (user_id, follower_id)
VALUES ('3df592a4-daa8-4819-863e-d4f7998ad0f3', 'd41ba763-57b5-4f8a-bdd2-2f3cc53b93a2'),
       ('3df592a4-daa8-4819-863e-d4f7998ad0f3', 'dab3e0c6-6b94-426e-8347-14a8fea8a42b'),
       ('3df592a4-daa8-4819-863e-d4f7998ad0f3', 'f6b24e76-2cd6-4881-86e9-ffadbba23720'),
       ('3df592a4-daa8-4819-863e-d4f7998ad0f3', 'fd81d17f-8ccb-4a65-a281-0a2d8ba25b2e'),
       ('3df592a4-daa8-4819-863e-d4f7998ad0f3', '061460f1-45fd-40a8-b243-5da3f0f35523');

--"charlie@example.com"
INSERT INTO public.user_followers (user_id, follower_id)
VALUES ('7826ee10-98d3-4cdc-96a6-2dfcdcb728d8', 'a8bcd7e3-d273-49c0-a226-259b02658c73'),
       ('7826ee10-98d3-4cdc-96a6-2dfcdcb728d8', 'add7566f-c8c9-4932-b165-7ce6a465b18e'),
       ('7826ee10-98d3-4cdc-96a6-2dfcdcb728d8', 'b5b8dbce-7d66-4399-868c-cde35c31c10a'),
       ('7826ee10-98d3-4cdc-96a6-2dfcdcb728d8', 'd41ba763-57b5-4f8a-bdd2-2f3cc53b93a2'),
       ('7826ee10-98d3-4cdc-96a6-2dfcdcb728d8', '063666bd-6ecb-440d-b560-dc306493fe59'),
       ('7826ee10-98d3-4cdc-96a6-2dfcdcb728d8', '3df592a4-daa8-4819-863e-d4f7998ad0f3');

-- "diana@example.com"
INSERT INTO public.user_followers (user_id, follower_id)
VALUES ('a8bcd7e3-d273-49c0-a226-259b02658c73', '063666bd-6ecb-440d-b560-dc306493fe59'),
       ('a8bcd7e3-d273-49c0-a226-259b02658c73', '3df592a4-daa8-4819-863e-d4f7998ad0f3'),
       ('a8bcd7e3-d273-49c0-a226-259b02658c73', '7826ee10-98d3-4cdc-96a6-2dfcdcb728d8');

-- "edward@example.com"
INSERT INTO public.user_followers (user_id, follower_id)
VALUES ('add7566f-c8c9-4932-b165-7ce6a465b18e', 'b5b8dbce-7d66-4399-868c-cde35c31c10a'),
       ('add7566f-c8c9-4932-b165-7ce6a465b18e', 'd41ba763-57b5-4f8a-bdd2-2f3cc53b93a2'),
       ('add7566f-c8c9-4932-b165-7ce6a465b18e', 'dab3e0c6-6b94-426e-8347-14a8fea8a42b'),
       ('add7566f-c8c9-4932-b165-7ce6a465b18e', 'f6b24e76-2cd6-4881-86e9-ffadbba23720'),
       ('add7566f-c8c9-4932-b165-7ce6a465b18e', 'fd81d17f-8ccb-4a65-a281-0a2d8ba25b2e'),
       ('add7566f-c8c9-4932-b165-7ce6a465b18e', '061460f1-45fd-40a8-b243-5da3f0f35523');


--"fiona@example.com"
INSERT INTO public.user_followers (user_id, follower_id)
VALUES ('b5b8dbce-7d66-4399-868c-cde35c31c10a', 'd41ba763-57b5-4f8a-bdd2-2f3cc53b93a2'),
       ('b5b8dbce-7d66-4399-868c-cde35c31c10a', 'dab3e0c6-6b94-426e-8347-14a8fea8a42b'),
       ('b5b8dbce-7d66-4399-868c-cde35c31c10a', 'f6b24e76-2cd6-4881-86e9-ffadbba23720');

--"george@example.com"
INSERT INTO public.user_followers (user_id, follower_id)
VALUES ('d41ba763-57b5-4f8a-bdd2-2f3cc53b93a2', 'dab3e0c6-6b94-426e-8347-14a8fea8a42b'),
       ('d41ba763-57b5-4f8a-bdd2-2f3cc53b93a2', 'f6b24e76-2cd6-4881-86e9-ffadbba23720'),
       ('d41ba763-57b5-4f8a-bdd2-2f3cc53b93a2', 'fd81d17f-8ccb-4a65-a281-0a2d8ba25b2e'),
       ('d41ba763-57b5-4f8a-bdd2-2f3cc53b93a2', '061460f1-45fd-40a8-b243-5da3f0f35523');

INSERT INTO public.user_followers (user_id, follower_id)
VALUES ('f6b24e76-2cd6-4881-86e9-ffadbba23720', '063666bd-6ecb-440d-b560-dc306493fe59'),
       ('f6b24e76-2cd6-4881-86e9-ffadbba23720', '3df592a4-daa8-4819-863e-d4f7998ad0f3'),
       ('f6b24e76-2cd6-4881-86e9-ffadbba23720', '7826ee10-98d3-4cdc-96a6-2dfcdcb728d8'),
       ('f6b24e76-2cd6-4881-86e9-ffadbba23720', 'a8bcd7e3-d273-49c0-a226-259b02658c73'),
       ('f6b24e76-2cd6-4881-86e9-ffadbba23720', 'add7566f-c8c9-4932-b165-7ce6a465b18e'),
       ('f6b24e76-2cd6-4881-86e9-ffadbba23720', 'b5b8dbce-7d66-4399-868c-cde35c31c10a'),
       ('f6b24e76-2cd6-4881-86e9-ffadbba23720', 'd41ba763-57b5-4f8a-bdd2-2f3cc53b93a2');

