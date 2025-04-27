INSERT INTO public.cco_user (user_id,
                             email,
                             user_password,
                             first_name,
                             last_name,
                             gender,
                             is_admin,
                             is_active,
                             nationality,
                             birthday,
                             introduction)
VALUES ('061460f1-45fd-40a8-b243-5da3f0f35523',
        'khangnguyn07022002@gmail.com',
        '$2a$05$bHb1fgUgqLr1F8PfOBrI4OzQHg3X7EEr5vj2uQfAH7uQSfi/MT4xS', -- Make sure to hash the password before inserting
        'Khang', -- Assuming first name
        'Nguyen', -- Assuming last name
        'Male', -- Assuming gender, adjust if needed
        false, -- Assuming user is not admin
        true, -- Assuming user is active
        'Vietnamese',-- Assuming nationality
        '2002-02-07', -- Assuming birthday
        '<p><strong>Hi, I''m Khang!</strong> I''m a passionate <span style="color: #4CAF50;">software developer</span> with a love for storytelling. I enjoy sharing stories that blend <em>technology</em> with creativity, and I believe the future is built on innovation. <span style="font-size: 20px;">🚀</span> I explore the endless possibilities of tech and love to inspire others through my work and stories. <span style="font-size: 20px;">💻</span> Welcome to my world of code and imagination!</p>');
