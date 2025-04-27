-- Insert story
INSERT INTO story
(story_id, release_status, story_title, story_description, user_id, created_time, language)
VALUES ('d8f6c2b7-5e3f-49c8-bc58-54d5b77b1234',
        true,
        'Ngôi Nhà Ma Trên Đồi Thông Đà Lạt',
        'Tại một vùng đồi hẻo lánh ở Đà Lạt, có một ngôi biệt thự cổ bị bỏ hoang, nơi mà người dân địa phương luôn rỉ tai nhau những câu chuyện ma quái. Khi nhóm bạn trẻ tò mò quyết định thám hiểm ngôi nhà ấy, họ đã đánh thức một bí mật đen tối bị chôn vùi suốt hàng chục năm. Mỗi đêm trôi qua, bóng tối nuốt chửng hy vọng sống sót của họ.',
        '061460f1-45fd-40a8-b243-5da3f0f35523',
        '2025-04-27 19:30:00.000000',
        'vi');

-- Insert Chapter 1
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('c3a9d8b2-47f7-4a89-b72e-23ac12345678',
        1,
        'Bước Vào Cõi Âm',
        'd8f6c2b7-5e3f-49c8-bc58-54d5b77b1234',
        '<p>Ánh hoàng hôn nhuốm đỏ cả bầu trời khi nhóm bạn chúng tôi — Minh, Thảo, Duy và tôi — đứng trước cánh cổng sắt gỉ sét, nhìn lên ngôi nhà bỏ hoang trên đỉnh đồi. Những cành thông già rì rào trong gió lạnh, như thì thầm những điều không ai muốn nghe. 🌲🌫️</p>
        <p>"Có chắc mình muốn vào không?" Thảo run rẩy hỏi. Nhưng sự tò mò đã chiến thắng nỗi sợ. Chúng tôi đẩy cổng bước vào, mỗi bước chân nặng trĩu giữa màn sương dày đặc. 😨</p>
        <p>Bên trong ngôi nhà, mùi ẩm mốc và lạnh lẽo bủa vây lấy chúng tôi. Những bức tranh chân dung trên tường nứt nẻ, đôi mắt như dõi theo từng cử động. Một tiếng cười khúc khích vang lên đâu đó, lạnh toát sống lưng. 👻</p>
        <p>Chúng tôi không biết rằng, từ khoảnh khắc bước chân qua cánh cửa ấy, linh hồn oán hận của ngôi nhà đã mở mắt chào đón những vị khách mới...</p>',
        '2025-04-27 19:31:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('b5d7e1a9-22e4-438a-8d8e-00aa12345671',
        2,
        'Tiếng Thì Thầm Trong Đêm',
        'd8f6c2b7-5e3f-49c8-bc58-54d5b77b1234',
        '<p>Đêm đầu tiên trong ngôi nhà, chúng tôi quyết định cắm trại ngay giữa phòng khách lạnh lẽo. 🕯️</p>
        <p>Khi tất cả đã chìm vào giấc ngủ, tôi bỗng giật mình tỉnh giấc vì nghe thấy tiếng thì thầm sát bên tai: "Cứu tôi..."</p>
        <p>Mở mắt ra, tôi chỉ thấy bóng tối đặc quánh và tiếng gió hú qua khe cửa vỡ. Nhưng sâu trong tiềm thức, tôi biết... ai đó, hay thứ gì đó, đang lặng lẽ quan sát chúng tôi. 👀</p>',
        '2025-04-27 19:35:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('a6b8f3c1-43d2-499b-a5e5-90ab12345672',
        3,
        'Người Con Gái Trong Gương',
        'd8f6c2b7-5e3f-49c8-bc58-54d5b77b1234',
        '<p>Ngày hôm sau, khi lang thang khám phá tầng trên, Thảo phát hiện một tấm gương cũ phủ bụi. Cô ấy lau sạch mặt gương — và ngay lập tức hét thất thanh. 🪞😱</p>
        <p>Trong gương, đứng sau lưng cô là một cô gái mặc áo dài trắng, mái tóc dài che khuất khuôn mặt. Nhưng khi quay đầu lại, phía sau Thảo không có ai cả.</p>
        <p>Từ đó, tấm gương bắt đầu tự mình phản chiếu những cảnh tượng kinh hoàng mà không ai dám nhìn lâu thêm một lần nào nữa. 🔥👻</p>',
        '2025-04-27 19:36:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('c7e9f4d2-57f5-41c1-b6e5-76bb12345673',
        4,
        'Căn Hầm Bị Lãng Quên',
        'd8f6c2b7-5e3f-49c8-bc58-54d5b77b1234',
        '<p>Khi khám phá khu vực bếp, Duy tìm thấy một cánh cửa gỗ nhỏ bị khóa chặt. Sau nhiều nỗ lực, chúng tôi phá được ổ khóa và mở cửa ra — một cầu thang xoắn dẫn xuống lòng đất. 🔦</p>
        <p>Không khí lạnh buốt và mùi tanh tưởi bốc lên nồng nặc. Dưới căn hầm, chúng tôi phát hiện những bức tranh vẽ nguệch ngoạc lên tường: hình ảnh những linh hồn bị xiềng xích và gào thét trong tuyệt vọng. 🔥💀</p>
        <p>Chúng tôi nhận ra: ngôi nhà này không chỉ đơn giản là "bị ma ám" — nó là nơi giam giữ những oán hồn chưa được siêu thoát.</p>',
        '2025-04-27 19:37:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('d8f0a5e3-68f7-4c92-82e5-12cc12345674',
        5,
        'Bóng Ma Của Chủ Nhân',
        'd8f6c2b7-5e3f-49c8-bc58-54d5b77b1234',
        '<p>Đêm thứ ba, khi đang nhóm lửa để xua tan cái lạnh, Minh bỗng lảo đảo như bị ai đó đẩy mạnh. 🕯️</p>
        <p>Chúng tôi quay lại thì thấy một bóng đen cao lớn đang đứng sừng sững bên lò sưởi — đôi mắt đỏ rực nhìn chằm chằm vào chúng tôi. 🧛🏻‍♂️</p>
        <p>Đó chính là hồn ma của vị chủ nhân đầu tiên của ngôi nhà, người từng bị đồn đã ra tay tàn sát chính gia đình mình để đổi lấy sự bất tử... Một lời nguyền kinh hoàng đã trói buộc linh hồn ông ta ở đây mãi mãi.</p>',
        '2025-04-27 19:38:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('e9f1b6f4-79f8-4fa3-91e5-23dd12345675',
        6,
        'Lời Nguyền Máu',
        'd8f6c2b7-5e3f-49c8-bc58-54d5b77b1234',
        '<p>Cuối cùng, chúng tôi tìm thấy một cuốn sách cổ bằng da người cất giấu dưới nền căn hầm. 📖🩸</p>
        <p>Trong đó ghi lại nghi thức tà ác mà chủ nhân ngôi nhà từng thực hiện: mỗi đời chủ mới đặt chân vào đây đều phải "hiến tế" để nuôi dưỡng ngôi nhà ma ám.</p>
        <p>Nhận ra điều đó, chúng tôi lập kế hoạch phá vỡ lời nguyền — nhưng trước khi thực hiện, một trong chúng tôi bắt đầu biến mất bí ẩn trong màn đêm... 🌑👤</p>',
        '2025-04-27 19:39:00.000000');

INSERT INTO story
(story_id, release_status, story_title, story_description, user_id, language, created_time)
VALUES ('c4b3f8e4-2453-4f5b-9f85-6b839bb7e453',
        true,
        'Linh Hồn Nữ Sinh Chết Oan',
        'Vào một đêm tối trời, tại một ngôi trường cổ kính, câu chuyện về một nữ sinh tên Lan, người đã chết oan dưới tay bạn học cũ, bắt đầu được kể lại. Linh hồn của Lan không thể siêu thoát, và cô ấy bắt đầu tìm cách trả thù những kẻ đã gây ra cái chết của mình. Những ai đã từng đối xử tàn nhẫn với Lan đều phải trả giá, và một chuỗi những cái chết bí ẩn liên tiếp xảy ra.',
        '061460f1-45fd-40a8-b243-5da3f0f35523',
        'vi',
        '2025-04-27 20:00:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('f9f8e7b6-c1d9-49e0-a7b7-7984bcb3e672',
        1,
        'Bóng Ma Trong Phòng Học',
        'c4b3f8e4-2453-4f5b-9f85-6b839bb7e453',
        '<p>Câu chuyện bắt đầu vào một buổi tối yên tĩnh, khi lớp học chỉ còn lại vài học sinh ở lại học nhóm. Một trong số họ là Minh, người vốn dĩ là bạn học cùng lớp với Lan.</p>
        <p>Nhưng Minh không thể ngờ rằng, trong buổi tối hôm đó, một linh hồn đang ẩn mình trong bóng tối. Đột nhiên, ánh đèn phòng học nhấp nháy, và Minh nghe thấy tiếng bước chân vang lên từ cuối lớp. Khi quay lại, anh ta thấy một hình bóng mờ ảo — một cô gái mặc đồng phục học sinh cũ, tóc dài phủ kín mặt.</p>
        <p>Minh sợ hãi, nhưng rồi nhận ra đó chính là Lan — nữ sinh đã qua đời cách đây một năm. Cô gái ấy chỉ đứng đó, không nói gì, đôi mắt trống rỗng chỉ nhìn thẳng vào Minh.</p>',
        '2025-04-27 20:05:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('d2b4f6c9-92f5-4a2d-80c4-b18943c5226a',
        2,
        'Đêm Kinh Hoàng',
        'c4b3f8e4-2453-4f5b-9f85-6b839bb7e453',
        '<p>Ngày hôm sau, Minh cảm thấy như có điều gì đó không ổn. Đêm qua, anh ta không thể ngủ vì ám ảnh bởi hình ảnh của Lan. Những chuyện kỳ lạ bắt đầu xảy ra. Đèn trong phòng học tự động bật tắt, những cánh cửa tự mở ra khi không có ai ở đó.</p>
        <p>Vào một đêm, Minh quyết định quay lại lớp học để tìm kiếm câu trả lời. Khi anh bước vào, một cơn gió lạnh bất ngờ thổi qua, khiến cửa sổ bị bật mở. Anh bước đến bàn của Lan — nơi mà chỉ một năm trước, cô gái ngồi đó, vui vẻ cùng bạn bè.</p>
        <p>Đột nhiên, Minh cảm thấy một bàn tay lạnh ngắt chạm vào vai mình. Quay lại, anh nhìn thấy Lan, nhưng lần này, cô không còn là một hình bóng mờ ảo. Đôi mắt của Lan đầy oán hận, và cô bắt đầu thì thầm: "Người đã giết tôi, sẽ phải trả giá".</p>',
        '2025-04-27 20:10:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('e5a1f9d0-b194-4088-b3e2-87643a8a8130',
        3,
        'Ngày Tàn Của Những Kẻ Thủ Ác',
        'c4b3f8e4-2453-4f5b-9f85-6b839bb7e453',
        '<p>Những hiện tượng kỳ lạ ngày càng gia tăng, và Minh không thể chịu đựng thêm nữa. Anh ta biết rằng phải làm gì đó để ngừng cơn ác mộng này. Một đêm, Minh tìm được một cuốn nhật ký cũ của Lan trong ngôi trường, ghi lại những nỗi đau và sự tủi nhục mà cô phải chịu đựng trước khi qua đời.</p>
        <p>Cô bị một nhóm học sinh trêu chọc, làm nhục và đẩy cô vào tuyệt vọng. Cô gái ấy chết trong một tai nạn, nhưng đó không phải là một tai nạn thông thường — đó là một cuộc trả thù từ những kẻ không thể chịu đựng sự khác biệt của Lan.</p>
        <p>Minh quyết định đối mặt với những kẻ đã hại Lan. Đêm hôm đó, một cuộc chiến bắt đầu diễn ra giữa những linh hồn bị oán hận và những kẻ đã gieo rắc nỗi đau cho cô gái ấy. Những bóng ma bắt đầu tấn công từng người một, đẩy họ vào sự hoảng loạn.</p>',
        '2025-04-27 20:15:00.000000');

-- Insert Story
INSERT INTO story
(story_id, release_status, story_title, story_description, user_id, language, created_time)
VALUES ('2a9f7b84-5cb4-4b45-a951-6e432fcdce42',
        true,
        'Linh Hồn Người Lính Trở Về Quê Hương',
        'Trong chiến tranh, một người lính Việt Nam đã hy sinh trong một trận đánh ác liệt. Linh hồn của anh không thể siêu thoát, mãi quay quắt tìm đường trở về quê hương để gặp lại gia đình, nhưng bóng tối đã bao trùm, anh không thể thoát khỏi nỗi đau khôn nguôi của cái chết oan. Anh bắt đầu một hành trình kinh hoàng từ chiến trường trở về nhà, đối diện với những bóng ma, những nỗi sợ hãi và sự ám ảnh của chiến tranh.',
        '061460f1-45fd-40a8-b243-5da3f0f35523',
        'vi',
        '2025-04-27 20:30:00.000000');

-- Insert Chapter 1: Cái Chết Trên Chiến Trường
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('b6cb2a53-5921-4645-83c9-b997d5449f74',
        1,
        'Cái Chết Trên Chiến Trường',
        '2a9f7b84-5cb4-4b45-a951-6e432fcdce42',
        '<p>Trận chiến trên vùng đất Quảng Trị khốc liệt, nơi những tiếng súng không ngừng vang vọng, và những cái chết đến với các chiến sĩ như những cơn mưa. Anh là một người lính trẻ, dũng cảm, nhưng không may mắn khi một viên đạn găm vào ngực, khiến anh ngã xuống giữa chiến trường. Máu loang ra trên nền đất đỏ, và anh không thể nói lời từ biệt với gia đình.</p>
        <p>Linh hồn anh chưa thể siêu thoát, mãi quẩn quanh trên chiến trường nơi anh đã hy sinh. Những âm thanh chiến tranh vẫn vang vọng trong tai anh, những hình ảnh khủng khiếp cứ hiện ra trước mắt, khiến anh không thể tìm được sự yên bình.</p>',
        '2025-04-27 20:35:00.000000');

-- Insert Chapter 2: Hành Trình Quay Về Quê Hương
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('5d3f4f83-dbbf-417d-a0d3-98657534b478',
        2,
        'Hành Trình Quay Về Quê Hương',
        '2a9f7b84-5cb4-4b45-a951-6e432fcdce42',
        '<p>Linh hồn anh bắt đầu cuộc hành trình từ chiến trường trở về quê hương. Đêm đen, những con đường vắng lặng, chỉ có tiếng gió thổi qua những cánh đồng lúa chín. Anh đi, đi mãi mà không biết sẽ đến đâu. Mỗi bước chân là một nỗi đau, một ký ức về trận chiến, về những đồng đội đã hy sinh, về những ngày đen tối của chiến tranh.</p>
        <p>Khi anh đến gần quê hương, anh nhìn thấy ngôi làng thân yêu của mình, nhưng không phải là cảnh tượng anh mong đợi. Làng quê giờ đây đã thay đổi, không còn những hình ảnh thân quen. Cánh cổng làng đóng im ỉm, và một bóng người đứng đó, lặng lẽ nhìn anh. Đó là một linh hồn, một người lính đã chết trong chiến tranh, như anh, nhưng không thể quay về.</p>',
        '2025-04-27 20:40:00.000000');

-- Insert Chapter 3: Đối Mặt Với Những Linh Hồn
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('3c7d4b5a-345f-4b8b-b91d-9cb1dfd81ae6',
        3,
        'Đối Mặt Với Những Linh Hồn',
        '2a9f7b84-5cb4-4b45-a951-6e432fcdce42',
        '<p>Trong bóng tối, linh hồn anh cảm thấy mình không cô đơn. Những linh hồn khác cũng đang vất vưởng, không thể siêu thoát, như anh. Họ là những người lính, những người dân vô tội đã chết trong cuộc chiến tranh. Những tiếng thì thầm, những âm thanh ma quái vang lên từ khắp nơi, khiến anh cảm thấy như mình bị bao vây.</p>
        <p>Anh bắt đầu thấy sợ hãi, nhưng không thể quay lại. Anh phải hoàn thành sứ mệnh của mình — đó là trở về nhà, gặp lại gia đình, và tìm cách để linh hồn anh có thể yên nghỉ. Nhưng càng đi, anh càng cảm thấy những linh hồn khác đang muốn kéo anh xuống, để anh chia sẻ nỗi khổ đau của họ.</p>',
        '2025-04-27 20:45:00.000000');

-- Insert Chapter 4: Cuộc Đụng Độ Cuối Cùng
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('25dba813-d8b0-4751-bd8a-e06d4b8753d7',
        4,
        'Cuộc Đụng Độ Cuối Cùng',
        '2a9f7b84-5cb4-4b45-a951-6e432fcdce42',
        '<p>Cuối cùng, linh hồn anh cũng quay về quê hương. Anh tìm thấy gia đình mình, nhưng ngôi nhà đã hoang tàn, không còn người thân. Linh hồn anh bỗng nhiên bừng tỉnh nhận ra rằng cuộc đời mình đã kết thúc, và anh không thể quay lại với quá khứ.</p>
        <p>Nhưng anh không bỏ cuộc. Anh quyết định đối mặt với những linh hồn khác, những người đã chết oan uổng trong chiến tranh. Anh chiến đấu để giúp họ siêu thoát, để cuộc chiến không còn ám ảnh họ nữa.</p>
        <p>Cuối cùng, một ánh sáng trắng chói lòa xuất hiện. Anh biết đó là con đường dẫn đến sự siêu thoát. Linh hồn anh, cùng với những linh hồn khác, từ từ bay lên, để lại phía sau những nỗi đau chiến tranh, bước vào một thế giới bình yên, nơi không còn chiến tranh và chết chóc.</p>',
        '2025-04-27 20:50:00.000000');

-- Insert Story
INSERT INTO story
(story_id, release_status, story_title, story_description, user_id, language, created_time)
VALUES ('7b8d9d70-bf6f-48ac-96f2-33a330c6fae2',
        true,
        'Linh Hồn Người Bán Bánh Giò',
        'Một người bán bánh giò tội nghiệp, ngày ngày ngồi bán hàng tại một con hẻm nhỏ, sống cuộc sống nghèo khó. Nhưng một ngày, anh ta bị giết chết dã man bởi những tên nghiện ma túy. Linh hồn anh không thể siêu thoát, mãi ám lấy con hẻm nơi anh đã nằm xuống, khiến cho mọi người qua lại cảm thấy sợ hãi và ám ảnh. Đến nay, không ai dám lại gần nơi đó vào ban đêm.',
        '061460f1-45fd-40a8-b243-5da3f0f35523',
        'vi',
        '2025-04-27 21:00:00.000000');

-- Insert Chapter 1: Người Bán Bánh Giò Tội Nghiệp
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('4b87f226-3f76-4d82-9bb6-83b57c3f9fba',
        1,
        'Người Bán Bánh Giò Tội Nghiệp',
        '7b8d9d70-bf6f-48ac-96f2-33a330c6fae2',
        '<p>Anh là một người bán bánh giò nghèo khó, ngày ngày ngồi ở con hẻm nhỏ bán những chiếc bánh giò nóng hổi cho những người qua lại. Cuộc sống của anh đơn giản, chỉ với niềm vui nhỏ nhoi là thấy khách hàng ăn xong, họ mỉm cười khen ngon.</p>
        <p>Nhưng cuộc sống tội nghiệp của anh không kéo dài lâu. Một đêm khuya, khi con hẻm trở nên tĩnh lặng, vài tên nghiện ma túy đã kéo đến. Chúng đã ra tay với anh một cách tàn bạo, giết chết anh ngay tại chỗ anh bán bánh giò mỗi ngày. Máu nhuộm đỏ con hẻm, chiếc bánh giò rơi xuống đất, nhưng không ai chứng kiến.</p>',
        '2025-04-27 21:05:00.000000');

-- Insert Chapter 2: Linh Hồn Không Siêu Thoát
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('9a7205c7-73ab-4d9c-9390-d988fc7c0b0f',
        2,
        'Linh Hồn Không Siêu Thoát',
        '7b8d9d70-bf6f-48ac-96f2-33a330c6fae2',
        '<p>Sau khi chết, linh hồn anh không thể siêu thoát. Mỗi đêm, anh vẫn lẩn quẩn trong con hẻm nơi anh đã ngã xuống. Những âm thanh kỳ lạ, những tiếng bước chân ma quái vang lên mỗi khi đêm về. Người ta kể rằng, vào lúc nửa đêm, ai đi ngang qua con hẻm này sẽ nghe thấy tiếng anh gọi, nhưng không ai dám quay lại nhìn.</p>
        <p>Có người nói rằng, anh chỉ muốn một lần được sống lại, để trả thù những kẻ đã giết mình. Nhưng linh hồn anh không thể rời bỏ nơi này, mãi mãi vướng mắc giữa cõi trần và thế giới bên kia, không thể yên nghỉ.</p>',
        '2025-04-27 21:10:00.000000');

-- Insert Chapter 3: Ám Ảnh Con Hẻm
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('2d519739-d8db-4657-980d-705e0ff8c6ad',
        3,
        'Ám Ảnh Con Hẻm',
        '7b8d9d70-bf6f-48ac-96f2-33a330c6fae2',
        '<p>Kể từ khi linh hồn anh bị giam giữ trong con hẻm, những người sống gần đó bắt đầu cảm thấy sự hiện diện kỳ lạ. Các gia đình không dám ra ngoài vào ban đêm, vì mỗi khi họ đi ngang qua, cảm giác lạnh lẽo bao trùm. Đôi khi, họ nghe thấy tiếng bánh giò rơi xuống đất, như thể anh vẫn còn ngồi bán hàng.</p>
        <p>Có người đã thử tìm hiểu về linh hồn anh, nhưng mỗi lần họ bước vào con hẻm đó, họ đều bị một cảm giác sợ hãi kỳ lạ đè nén, khiến họ không thể tiếp tục. Một số người còn gặp phải ảo giác, thấy bóng dáng anh đứng đó, mắt mở trừng trừng, với ánh mắt cầu cứu. Nhưng không ai dám giúp anh, vì ai cũng biết linh hồn anh không thể siêu thoát.</p>',
        '2025-04-27 21:15:00.000000');

-- Insert Chapter 4: Mùa Xuân Đến
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('a420b9d5-d2d0-433f-98d1-537d0b8f3d6d',
        4,
        'Mùa Xuân Đến',
        '7b8d9d70-bf6f-48ac-96f2-33a330c6fae2',
        '<p>Vào một đêm đông giá lạnh, một nhóm thanh niên tò mò đã quyết định thách thức và bước vào con hẻm đó. Khi họ đến gần, họ nghe thấy tiếng bánh giò rơi xuống đất, và một bóng hình mờ ảo xuất hiện trước mặt họ. Chỉ là một người đàn ông, khuôn mặt hiền lành, nhưng ánh mắt của anh như mang theo nỗi đau đớn, mất mát.</p>
        <p>Nhóm thanh niên kinh hãi bỏ chạy, nhưng linh hồn anh vẫn không thể siêu thoát. Họ kể lại câu chuyện cho những người khác, nhưng không ai dám quay lại con hẻm đó. Từ đó, con hẻm trở nên hoang vắng, và linh hồn người bán bánh giò mãi ám ảnh những ai dám lại gần, không thể nào yên nghỉ.</p>',
        '2025-04-27 21:20:00.000000');

-- Insert Story
INSERT INTO story
(story_id, release_status, story_title, story_description, user_id, language, created_time)
VALUES ('3f9a690b-94d7-4c7b-a243-907d0a254a11',
        true,
        'Bảy Tội Lỗi Của Con Người',
        'Một câu chuyện gồm bảy chương, mỗi chương khám phá một trong bảy tội lỗi của con người theo Kinh thánh. Mỗi tội lỗi đều mang một bài học cảnh tỉnh, khiến con người phải đối diện với hậu quả của những hành động xấu xa và không nhân đạo của mình.',
        '061460f1-45fd-40a8-b243-5da3f0f35523',
        'vi',
        '2025-04-27 22:00:00.000000');

-- Insert Chapter 1: Kiêu Ngạo (Pride)
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('0e62f592-f5f2-4690-a8c5-d5fd1e97b1a1',
        1,
        'Kiêu Ngạo',
        '3f9a690b-94d7-4c7b-a243-907d0a254a11',
        '<p>Minh, một chàng trai trẻ đầy tài năng và khéo léo, đã có được mọi thứ mà anh ta muốn trong cuộc sống. Anh tự mãn về bản thân, cho rằng mình vượt trội hơn những người xung quanh. Anh khinh thường những người nghèo, những người không thể đạt được như anh, và luôn coi mình là trung tâm của vũ trụ.</p>
        <p>Vào một ngày nọ, anh ta gặp phải một tai nạn nghiêm trọng, và tất cả những gì anh từng tự hào đều tan vỡ. Bệnh tật và nghèo khó bao phủ lấy anh. Khi anh nhận ra rằng mình không thể tự làm chủ được cuộc sống, kiêu ngạo đã khiến anh phải trả giá. Anh bắt đầu cảm nhận được nỗi đau của sự thất bại và sự hạ thấp mình. Kiêu ngạo đã biến anh từ một người tự tin thành một con người cô đơn và thất bại.</p>',
        '2025-04-27 22:05:00.000000');

-- Insert Chapter 2: Ghen Tỵ (Envy)
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('f5781c53-3720-46c1-8c51-8a7b88db66b1',
        2,
        'Ghen Tỵ',
        '3f9a690b-94d7-4c7b-a243-907d0a254a11',
        '<p>Linh luôn cảm thấy ghen tị với người bạn của mình, Hà. Hà là người thành đạt, xinh đẹp và sống một cuộc sống hạnh phúc. Mỗi lần nhìn thấy thành công của Hà, Linh cảm thấy mình như bị tụt lại phía sau. Ghen tị đã trở thành một nỗi ám ảnh trong lòng Linh, khiến cô không thể vui vẻ với những gì mình có.</p>
        <p>Cuối cùng, ghen tị đã đẩy Linh vào con đường sai lầm. Cô đã tìm cách làm tổn thương Hà, phá hỏng những thành công của người bạn. Tuy nhiên, khi nhìn thấy Hà vượt qua tất cả khó khăn và tiếp tục tỏa sáng, Linh nhận ra rằng ghen tị chỉ mang lại sự đau khổ cho chính bản thân mình. Cô học được rằng hạnh phúc thật sự đến từ việc trân trọng những gì mình có và không so sánh với người khác.</p>',
        '2025-04-27 22:10:00.000000');

-- Insert Chapter 3: Giận Dữ (Wrath)
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('7221dfd5-7e76-4c5e-9009-17000c345290',
        3,
        'Giận Dữ',
        '3f9a690b-94d7-4c7b-a243-907d0a254a11',
        '<p>Nam là một người luôn bị cuốn vào những cơn giận dữ. Mỗi khi có điều gì đó không vừa lòng, anh lập tức bùng nổ, không thể kiểm soát được cảm xúc của mình. Cơn giận dữ khiến anh trở thành một người khó gần và gây tổn thương cho những người xung quanh.</p>
        <p>Vào một lần, Nam đã làm tổn thương người bạn thân nhất của mình vì một lý do nhỏ nhặt. Sau khi nhận ra những gì mình đã làm, Nam cảm thấy vô cùng hối hận. Giận dữ không chỉ làm anh mất đi bạn bè mà còn khiến anh đánh mất những cơ hội quý giá trong cuộc sống. Cuối cùng, Nam học được rằng chỉ khi biết kiềm chế giận dữ, con người mới có thể sống bình yên và hạnh phúc.</p>',
        '2025-04-27 22:15:00.000000');

-- Insert Chapter 4: Lười Biếng (Sloth)
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('8d04039b-4da4-4d89-9300-d2b290ecbe2b',
        4,
        'Lười Biếng',
        '3f9a690b-94d7-4c7b-a243-907d0a254a11',
        '<p>Hải là một chàng trai lười biếng, luôn trốn tránh công việc và trách nhiệm. Anh cảm thấy mọi thứ đều không đáng làm, chỉ muốn dành thời gian để nghỉ ngơi và chơi bời. Thế nhưng, với thái độ sống như vậy, Hải đã đánh mất rất nhiều cơ hội trong cuộc sống.</p>
        <p>Cuối cùng, khi nhìn thấy bạn bè của mình thành công, Hải nhận ra rằng cuộc sống không chờ đợi ai. Lười biếng đã khiến anh mất đi những cơ hội quan trọng và làm cho anh phải sống trong hối hận. Câu chuyện của Hải là một bài học về tầm quan trọng của sự chăm chỉ và kiên nhẫn trong cuộc sống.</p>',
        '2025-04-27 22:20:00.000000');

-- Insert Chapter 5: Tham Lam (Greed)
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('c573bd87-2057-4323-9b60-3c48c033a327',
        5,
        'Tham Lam',
        '3f9a690b-94d7-4c7b-a243-907d0a254a11',
        '<p>Minh là một doanh nhân thành đạt, nhưng tham lam đã khiến anh không bao giờ cảm thấy đủ. Mặc dù có rất nhiều tài sản và quyền lực, nhưng anh luôn khao khát có thêm nhiều hơn nữa. Anh làm tất cả mọi thứ để đạt được mục tiêu của mình, bất chấp hậu quả đối với người khác.</p>
        <p>Cuối cùng, tham lam đã dẫn Minh đến một vụ thất bại lớn. Anh mất tất cả tài sản và tình bạn. Anh nhận ra rằng, khi một người quá tham lam, họ không bao giờ cảm thấy thỏa mãn và luôn sống trong nỗi lo sợ mất mát. Minh học được rằng hạnh phúc không đến từ việc tích lũy tài sản mà từ việc biết đủ và chia sẻ với người khác.</p>',
        '2025-04-27 22:25:00.000000');

-- Insert Chapter 6: Dục Vọng (Lust)
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('a95b38c1-cb12-4d42-8502-fd50c37872c1',
        6,
        'Dục Vọng',
        '3f9a690b-94d7-4c7b-a243-907d0a254a11',
        '<p>Linh là một cô gái trẻ, đầy khát khao và dục vọng. Cô bị cuốn vào những mối quan hệ không lành mạnh, tìm kiếm sự thỏa mãn tạm thời mà không nghĩ đến hậu quả lâu dài. Cuối cùng, Linh nhận ra rằng dục vọng không mang lại hạnh phúc thật sự, mà chỉ là sự trống rỗng và cô đơn.</p>
        <p>Với sự thức tỉnh từ những trải nghiệm đau đớn, Linh bắt đầu tìm kiếm một tình yêu chân thành và một cuộc sống đầy ý nghĩa. Câu chuyện của Linh là một bài học về sự kiên nhẫn và tình yêu chân thật.</p>',
        '2025-04-27 22:30:00.000000');

-- Insert Chapter 7: Tự Mãn (Pride)
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('b62c3a76-8e57-40e2-9f98-76db41ac6eb5',
        7,
        'Tự Mãn',
        '3f9a690b-94d7-4c7b-a243-907d0a254a11',
        '<p>Tùng là một người có tài năng vượt trội trong lĩnh vực nghệ thuật. Anh tự mãn về những gì mình đã đạt được, cảm thấy không ai có thể sánh bằng. Nhưng sự tự mãn của anh đã khiến anh trở nên xa cách và kiêu căng.</p>
        <p>Cuối cùng, Tùng nhận ra rằng, sự tự mãn đã đánh mất cơ hội học hỏi và cải thiện bản thân. Anh học được rằng sự khiêm tốn và sự sẵn sàng học hỏi là yếu tố quan trọng giúp con người phát triển và trưởng thành.</p>',
        '2025-04-27 22:35:00.000000');

