-- Insert story
INSERT INTO story
(story_id, release_status, story_title, story_description, user_id, created_time, language, cover_image_uri)
VALUES ('d8f6c2b7-5e3f-49c8-bc58-54d5b77b1234',
        true,
        'Ngôi Nhà Ma Trên Đồi Thông Đà Lạt',
        'Tại một vùng đồi hẻo lánh ở Đà Lạt, có một ngôi biệt thự cổ bị bỏ hoang, nơi mà người dân địa phương luôn rỉ tai nhau những câu chuyện ma quái. Khi nhóm bạn trẻ tò mò quyết định thám hiểm ngôi nhà ấy, họ đã đánh thức một bí mật đen tối bị chôn vùi suốt hàng chục năm. Mỗi đêm trôi qua, bóng tối nuốt chửng hy vọng sống sót của họ.',
        '061460f1-45fd-40a8-b243-5da3f0f35523',
        '2025-04-27 19:30:00.000000',
        'vi', '/uploads/sample_book_cover/ngoi_nha_ma_tren_doi_thong_da_lat.png');

-- Insert Chapter 1
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('c3a9d8b2-47f7-4a89-b72e-23ac12345678',
        1,
        'Lời Đồn Giữa Màn Sương',
        'd8f6c2b7-5e3f-49c8-bc58-54d5b77b1234',
        '<p>Đà Lạt vào một buổi sáng mùa thu mờ ảo. Sương mù phủ dày đặc trên những triền đồi thông u tịch, khiến cho cả thành phố như chìm vào một thế giới khác – mờ nhòe, ma mị và đầy bí ẩn. Tiếng chuông gió leng keng khe khẽ bên hiên một quán cà phê cổ kính vang lên như những hồi chuông báo hiệu một điều gì đó chẳng lành đang đến gần.</p>

<p>Bên trong quán, năm người bạn thân từ thời đại học – <strong>Nam</strong>, <strong>Linh</strong>, <strong>Tuấn</strong>, <strong>Hà</strong> và <strong>Phúc</strong> – đang tụ họp sau một thời gian dài xa cách. Quán cà phê này từng là nơi họ thường xuyên lui tới trong những chuyến đi phượt thời sinh viên, nơi chứa đầy kỷ niệm, nhưng hôm nay không khí dường như lạnh lẽo hơn thường lệ.</p>

<p>Giữa lúc cuộc trò chuyện rôm rả xoay quanh công việc và cuộc sống, Hà bất ngờ hỏi: “Mấy người còn nhớ ngôi biệt thự hoang trên đồi thông không? Cái nơi mà người ta hay đồn có ma á…” Cô nói, ánh mắt thoáng vẻ mơ màng pha chút rụt rè.</p>

<p>“Nghe bảo hồi xưa cả gia đình chủ nhà chết một cách bí ẩn, đến giờ vẫn không ai dám ở,” Tuấn chen vào, giọng nửa tin nửa ngờ. “Có người bảo vào buổi tối, nếu đứng trước cổng biệt thự mà lắng tai nghe kỹ, sẽ nghe thấy tiếng khóc của một người phụ nữ…”</p>

<p>Linh bỗng rùng mình, kéo sát chiếc khăn choàng. “Mấy chuyện đó chắc đồn cho vui thôi. Nhưng cũng rợn người thật.”</p>

<p>Nam – kẻ phiêu lưu nhất nhóm – cười lớn: “Vậy thì tối mai mình lên đó đi. Lâu rồi không làm gì kích thích một chút. Biết đâu lại có chuyện hay ho để kể.”</p>

<p>“Điên à?” – Linh phản đối. “Lỡ có chuyện gì thì sao?”</p>

<p>Phúc, vốn là người điềm đạm, nhìn ra ngoài trời, nơi lớp sương mù đang dày đặc hơn. “Chúng ta từng đi qua bao nhiêu nơi rừng sâu nước độc, một căn nhà hoang thì có gì đâu. Tối mai nhé.”</p>

<p>Không khí trong quán chợt thay đổi. Một làn gió lạnh lùa qua khe cửa, làm những tấm rèm cửa bay phần phật. Trong khoảnh khắc mất điện chớp nhoáng, bóng một người phụ nữ mặc áo dài trắng thấp thoáng qua tấm kính mờ. Tất cả im lặng. Không ai nói gì, nhưng đôi mắt của mỗi người đều ngập tràn hoang mang.</p>

<p>Ý tưởng đi thám hiểm ban đầu chỉ là trò đùa – nhưng giờ đây, có điều gì đó như đang dẫn dắt họ. Không ai biết, quyết định ấy sẽ kéo họ vào một chuỗi ngày kinh hoàng, nơi ranh giới giữa thực và ảo, sống và chết, chỉ cách nhau một hơi thở.</p>

<p><em>Đồi thông sẽ không chỉ là kỷ niệm. Nó sẽ là nơi chôn vùi tất cả...</em></p>',
        '2025-04-27 19:31:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('b5d7e1a9-22e4-438a-8d8e-00aa12345671',
        2,
        'Con đường mù sương',
        'd8f6c2b7-5e3f-49c8-bc58-54d5b77b1234',
        '<p>Tối hôm sau, màn đêm buông xuống nhanh hơn thường lệ. Bầu trời Đà Lạt trở nên xám xịt, không trăng, không sao, chỉ có những lớp sương mù dày đặc trườn xuống các sườn đồi như những tấm màn tang trắng. Cả nhóm tụ tập trước cổng rừng thông, nơi dẫn vào con đường đất nhỏ hẹp dẫn lên ngôi biệt thự bị bỏ hoang.</p>

<p>“Chúng ta chắc chắn về chuyện này chứ?” – Linh hỏi, tay nắm chặt đèn pin. Giọng cô run nhẹ, không rõ vì lạnh hay vì lo lắng.</p>

<p>Nam dẫn đầu, cười lớn để xua đi sự căng thẳng: “Sợ gì, có năm người lận. Với lại chúng ta chỉ đến xem rồi về thôi, đâu có ở lại.”</p>

<p>Họ bắt đầu bước đi trên con đường nhỏ giữa rừng thông. Những cây thông cao lớn, đứng chen chúc sát nhau, tạo nên bầu không khí ngột ngạt lạ thường. Tiếng bước chân lạo xạo trên lớp lá khô, thỉnh thoảng vang lên tiếng cú rúc khiến ai nấy đều giật mình.</p>

<p>Đi được một đoạn, Hà bất chợt dừng lại: “Mọi người có nghe thấy gì không? Như tiếng ai đó thì thầm…”</p>

<p>Phúc liếc nhìn quanh, nhưng ngoài âm thanh của gió và lá cây xào xạc, không có gì khác thường. “Chắc gió thôi mà,” anh nói, nhưng nét mặt có phần căng thẳng.</p>

<p>Đi được gần nửa giờ, sương mù càng lúc càng dày đặc. Ánh đèn pin chỉ chiếu được vài bước trước mặt. Cả nhóm phải bám sát nhau để không bị lạc. Đúng lúc đó, con đường đột ngột rẽ ngoặt. Một tấm cổng sắt han gỉ hiện ra giữa màn sương, gần như ẩn mình dưới lớp dây leo rậm rạp.</p>

<p>“Tới nơi rồi…” – Nam nói khẽ. Cánh cổng cũ kỹ dường như đã không được chạm đến trong nhiều năm. Một tấm bảng gỗ treo lủng lẳng bên cổng, chữ đã mờ gần hết, chỉ còn lờ mờ dòng chữ <em>“Cấm vào – Khu vực nguy hiểm”</em>.</p>

<p>“Chúng ta thực sự nên quay về,” Linh thì thầm, nhưng không ai đáp lại. Một thứ gì đó vô hình đang lôi kéo cả nhóm bước vào bên trong.</p>

<p>Nam đưa tay đẩy cổng. Nó kêu lên một tiếng <strong>két</strong> dài, rợn người, rồi mở ra chậm rãi như chào đón những vị khách không mời. Phía trước là một con đường lát đá lởm chởm dẫn lên ngọn đồi, nơi ngôi biệt thự u ám đang lẩn khuất trong bóng tối.</p>

<p>Bầu không khí đặc quánh như thể thời gian nơi đây bị đóng băng từ rất lâu rồi. Mỗi bước chân họ đặt lên con đường ấy như đang lùi sâu vào một thế giới khác – nơi mà ánh sáng, lý trí và cả hy vọng dường như không còn chỗ tồn tại.</p>

<p><em>Đêm đầu tiên đã bắt đầu. Và không một ai trong số họ biết rằng, cánh cổng sau lưng mình đã khép lại từ lúc nào.</em></p>
',
        '2025-04-27 19:35:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('a6b8f3c1-43d2-499b-a5e5-90ab12345672',
        3,
        'Tiếng Gọi Trong Đêm',
        'd8f6c2b7-5e3f-49c8-bc58-54d5b77b1234',
        '<p>Ngôi biệt thự hiện ra như một bóng ma giữa màn sương. Từng mảng tường rêu phong, cửa kính vỡ, mái ngói sụp xuống ở vài chỗ. Cảnh tượng trước mắt khiến tất cả nín lặng. Sự phấn khích ban đầu đã hoàn toàn tan biến, thay vào đó là một cảm giác bất an bám lấy từng hơi thở.</p>

<p>“Chúng ta chỉ nhìn xung quanh rồi đi nhé,” Tuấn nói, giọng trầm xuống rõ rệt. Phúc gật đầu, nhưng đôi mắt anh không giấu nổi vẻ nghi hoặc. Nam vẫn đi trước, đầy tự tin, như thể nơi đây là điểm đến của một trò chơi mạo hiểm đã được tính toán kỹ.</p>

<p>Họ bước vào nhà bằng lối cửa chính đã mục nát, bản lề kêu rên rỉ. Bên trong tối om. Mùi ẩm mốc, gỗ mục và thứ gì đó giống như máu khô khiến Linh lập tức đưa tay bịt miệng. Những bức tranh chân dung cũ kỹ treo trên tường, ánh mắt từ tranh như đang dõi theo từng cử động của họ.</p>

<p>“Nơi này giống như bị mắc kẹt trong thời gian,” Hà nói, bàn tay run rẩy cầm đèn pin quét một vòng quanh phòng khách. Bỗng nhiên, tiếng bước chân vang lên từ tầng hai. Tất cả đứng sững. Không ai vừa di chuyển cả.</p>

<p>“Có ai khác trong nhà này không?” – Linh thốt lên, lùi lại sát Nam.</p>

<p>Nam nheo mắt nhìn lên cầu thang gỗ. “Chắc là chuột thôi,” anh nói, rồi quay lại trấn an cả nhóm. Nhưng khi ánh đèn pin lia qua hành lang, một cái bóng vụt qua. Nhanh như gió.</p>

<p>“Cái gì vậy!?” – Hà hét lên.</p>

<p>“Bình tĩnh đã! Tuấn đâu rồi?” – Phúc đột ngột nhận ra.</p>

<p>Họ nhìn quanh. Tuấn – người đi sau cùng – đã biến mất từ lúc nào. Không ai nghe thấy tiếng la, tiếng động. Chỉ là... anh không còn ở đó.</p>

<p>Nam dẫn nhóm chia nhau tìm kiếm, chia làm hai tốp nhỏ. Linh và Phúc đi về phía nhà bếp, trong khi Nam và Hà lên lầu. Nhưng chưa kịp đi xa, một tiếng thét chói tai vang lên từ phía sau nhà. Cả nhóm tức tốc chạy tới.</p>

<p>Họ phát hiện Tuấn... nằm bất động dưới giếng cạn phía sau biệt thự. Đôi mắt mở to kinh hoàng, môi mấp máy như định nói điều gì trước khi chết. Trên cổ anh là những vết bầm tím – như bị bóp nghẹt bởi bàn tay vô hình.</p>

<p>Linh ôm mặt khóc nức nở. “Không thể nào… chúng ta mới chỉ vừa đến đây!”</p>

<p>Phúc siết chặt tay, nhìn xuống xác bạn mình. “Chúng ta phải rời khỏi đây ngay lập tức.”</p>

<p>Nam lắc đầu: “Không thể. Điện thoại mất sóng. Và con đường... không còn ở phía sau.”</p>

<p>Họ quay lại nhìn cánh cổng sắt – nơi họ từng bước qua. Giờ đây, chỉ còn là một bức tường rậm rạp dây leo, như chưa từng có lối vào.</p>

<p><em>Họ đã bị mắc kẹt. Và cái chết của Tuấn chỉ là sự khởi đầu.</em></p>
',
        '2025-04-27 19:36:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('c7e9f4d2-57f5-41c1-b6e5-76bb12345673',
        4,
        'Nhật ký máu',
        'd8f6c2b7-5e3f-49c8-bc58-54d5b77b1234',
        '<p>Không khí trong ngôi biệt thự giờ đây như bị bóp nghẹt. Cái chết đột ngột của Tuấn khiến mọi người mất phương hướng. Linh vẫn chưa ngừng khóc, còn Hà thì ngồi bệt xuống nền nhà, ánh mắt vô hồn.</p>

<p>Nam cố giữ bình tĩnh: “Chúng ta không thể ở đây mà chờ chết. Phải tìm hiểu xem thứ gì đang xảy ra. Có thể trong nhà có lối ra khác, hoặc ít nhất là thứ gì đó chỉ dẫn.”</p>

<p>Phúc gật đầu, giọng lạc hẳn: “Tôi cũng nghĩ thế. Chúng ta chia ra tìm hiểu các phòng, nhưng không được tách nhóm nữa. Ai cũng phải đi cùng ít nhất một người.”</p>

<p>Họ bắt đầu khám phá tầng trệt, lục tìm mọi thứ trong các phòng. Mỗi căn phòng là một thế giới chết chóc: phòng ăn phủ bụi dày, bàn ăn còn nguyên bộ bát đĩa sứ như bị bỏ lại giữa bữa ăn dang dở; phòng khách có tủ sách đầy sách cũ với nhiều trang bị xé rách; và cuối cùng, họ tìm thấy một căn phòng nhỏ nằm sau lưng bếp, như một kho chứa tạm bị niêm kín bằng đinh gỉ.</p>

<p>Nam dùng xà beng đập bung cửa. Bên trong là một căn phòng chật chội, chỉ có một chiếc bàn gỗ mục nát và một cuốn sổ dày phủ đầy bụi nằm trên đó.</p>

<p>Phúc nhặt lên, lau sơ bìa và đọc to nhan đề đã mờ: <em>“Nhật ký của bác sĩ Hoàng – 1972”</em>. Những dòng chữ bên trong viết tay nguệch ngoạc, nhiều trang dính máu khô. Họ lặng người khi đọc được những đoạn viết về thí nghiệm trên trẻ em, những giấc ngủ bị chi phối bởi ảo giác, và những tiếng nói vang lên trong đầu bệnh nhân.</p>

<p><em>“Tôi không còn kiểm soát được nữa. Những đứa trẻ biến đổi. Có thứ gì đó trong ngôi nhà này… nó điều khiển mọi thứ.”</em></p>

<p>“Đây từng là bệnh viện tâm thần ngầm?” – Hà thì thầm, lùi lại, mặt tái xanh.</p>

<p>Đúng lúc đó, tiếng rít chói tai vang lên từ phía hành lang. Cả nhóm giật mình quay lại thì thấy… Linh đã biến mất.</p>

<p>“Linh!” – Nam hét lên, chạy theo hướng âm thanh. Họ lao ra hành lang, đèn pin quét loạng choạng trên tường. Cửa phòng tắm mở toang. Và bên trong...</p>

<p>... là Linh. Cô nằm co quắp trong bồn tắm rỉ sét, mắt trợn trắng, miệng há hốc. Hai bàn tay cô cào cấu da thịt đến rớm máu như thể cố gắng thoát khỏi một nỗi ám ảnh vô hình. Trên tường, có dòng chữ được viết bằng máu:</p>

<p><strong><em>“Một người nữa. Vẫn chưa đủ.”</em></strong></p>

<p>Hà hét lên thảm thiết, ngã quỵ xuống nền gạch lạnh ngắt. Phúc đứng lặng, bàn tay nắm chặt cuốn nhật ký. Nam quay mặt đi, nhưng đôi mắt đỏ hoe không giấu được sự phẫn nộ.</p>

<p>“Thứ này… nó không muốn chúng ta rời đi. Nó đang chơi đùa.”</p>

<p>Bên ngoài, sương mù lại dày lên. Ngôi nhà rên rỉ trong gió như đang cười. Và họ biết: <em>họ chỉ còn ba người…</em></p>
',
        '2025-04-27 19:37:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('d8f0a5e3-68f7-4c92-82e5-12cc12345674',
        5,
        'Bóng ma ký ức',
        'd8f6c2b7-5e3f-49c8-bc58-54d5b77b1234',
        '<p>Tiếng gió hú hòa lẫn với tiếng mưa rơi lộp độp trên mái ngói mục nát tạo thành bản hòa âm chết chóc. Ba người còn lại – Nam, Phúc và Hà – ngồi trong phòng khách, bao quanh bởi những cuốn sách phủ bụi và ký ức đang thức tỉnh.</p>

<p>Phúc mở lại cuốn nhật ký của bác sĩ Hoàng. Giọng anh run run đọc tiếp:</p>

<p><em>“Ngày 12 tháng 9 năm 1972 – Thí nghiệm thất bại. Những đứa trẻ bắt đầu nghe thấy giọng nói, và rồi… chúng không còn là chính mình nữa. Có thứ gì đó trong ngôi nhà này đã thức tỉnh. Tôi thấy nó trong gương. Nó là chính tôi... hoặc từng là tôi.”</em></p>

<p>Hà ôm đầu, đôi mắt như dại đi: “Những đứa trẻ đó... bị đem ra làm vật thí nghiệm? Trên chính vùng đất này sao?”</p>

<p>Nam đứng dậy, cầm đèn pin và nói: “Tôi cần kiểm tra lại tầng hầm. Trong bản vẽ ngôi nhà có ghi chú ‘phòng đặc biệt’ dưới lòng đất. Có thể đó là nơi mọi thứ bắt đầu.”</p>

<p>Phúc do dự một lúc rồi gật đầu: “Tôi sẽ đi cùng. Hà, em nên ở lại đây.”</p>

<p>“Không! Tôi không ở một mình nữa đâu!” – Hà kêu lên. Cô vẫn chưa hoàn hồn từ cái chết của Linh, nhưng nỗi sợ ở một mình còn lớn hơn.</p>

<p>Cả ba cùng xuống tầng hầm. Cầu thang gỗ mục nát kêu rên rỉ dưới bước chân. Ánh sáng đèn pin chập chờn như sắp tắt. Khi đến nơi, họ phát hiện một cánh cửa sắt dày khóa bằng ổ khóa cũ kỹ.</p>

<p>Nam dùng xà beng phá khóa. Khi cửa bật mở, một luồng hơi lạnh như tử khí tràn ra. Bên trong là căn phòng kín không cửa sổ. Tường được lót bằng đệm cách âm, ở giữa là chiếc ghế sắt với dây trói. Trên tường có hàng trăm vết khắc chằng chịt:</p>

<p><em>“Đừng tin hắn.” – “Tôi vẫn còn sống.” – “Tôi nghe thấy mẹ.” – “Nó đang nhìn.”</em></p>

<p>Hà bước lùi lại, miệng lắp bắp: “Đây không phải bệnh viện… đây là phòng tra tấn.”</p>

<p>Phúc mở một tủ hồ sơ bên góc. Bên trong là những tập hồ sơ y tế, ghi tên hàng chục đứa trẻ. Mỗi tệp đều kết thúc bằng dòng: <em>“Đối tượng không phản hồi. Chuyển xử lý.”</em></p>

<p>Nam cầm một bản hồ sơ lên. Khi đọc tên, anh chết lặng: “Nguyễn Văn Nam – 5 tuổi – ký hiệu: Thí nghiệm số 14.”</p>

<p>“Đợi đã…” – Hà thì thào – “Nam… đó là tên anh.”</p>

<p>Nam siết chặt tay, trán toát mồ hôi. “Tôi không nhớ gì về tuổi thơ. Bố mẹ tôi… chỉ nói rằng tôi được nhận nuôi sau một vụ cháy lớn ở viện mồ côi gần Đà Lạt.”</p>

<p>Phúc nhìn Nam chằm chằm. “Anh là một trong những đứa trẻ được thí nghiệm?”</p>

<p>Trước khi Nam kịp phản ứng, đèn pin phụt tắt. Một tiếng thét vang lên – Hà bị kéo ngược vào bóng tối, bàn tay vô hình siết lấy cổ cô. Phúc và Nam lao đến nhưng không thấy gì ngoài một làn khói đen đặc quánh như tro tàn.</p>

<p>Tiếng Hà dần im bặt. Chỉ còn lại làn khói nhạt và một sợi dây chuyền rơi lại trên sàn lạnh lẽo.</p>

<p>Nam quỳ xuống, nắm lấy sợi dây. “Chúng ta không thể thoát nếu chưa đối mặt với nó.”</p>

<p>Phúc gật đầu, ánh mắt tràn đầy đau thương. “Chỉ còn lại hai người. Và tôi sợ… người tiếp theo sẽ là tôi.”</p>

<p>Bên trong những bức tường ngôi nhà, tiếng cười khúc khích vang lên. <em>Không phải của con người.</em></p>
',
        '2025-04-27 19:38:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('e9f1b6f4-79f8-4fa3-91e5-23dd12345675',
        6,
        'Lời thì thầm cuối cùng',
        'd8f6c2b7-5e3f-49c8-bc58-54d5b77b1234',
        '<p>Trong không khí đặc quánh và ẩm mốc của tầng hầm, Nam và Phúc đứng bất động trước cái chết đầy ám ảnh của Hà. Căn phòng im lặng đến nghẹt thở. Không còn tiếng gió, tiếng mưa, hay cả tiếng thì thầm quái đản – như thể ngôi nhà đang nín thở... chờ đợi.</p>

<p>Phúc run rẩy chạm tay vào vai Nam: “Chúng ta phải rời khỏi đây. Không còn gì để tìm nữa.”</p>

<p>Nhưng Nam lắc đầu, mắt đỏ rực, ánh nhìn như bừng tỉnh khỏi một cơn mê: “Tôi phải biết sự thật. Nếu tôi là một phần trong cái thí nghiệm này… nếu tôi sống sót… thì tôi cần biết tại sao.”</p>

<p>Họ quay lại phòng chứa tài liệu, lật tung những ngăn kéo cuối cùng. Một cuốn băng ghi âm được giấu trong hộp thiếc cũ. Bên ngoài đề: <em>“Ghi âm cuối cùng – 15/11/1972”</em>. Họ tìm thấy một máy phát cũ, lắp pin và bấm nút.</p>

<p><em>“Tôi là bác sĩ Hoàng… nếu ai đó tìm thấy cuốn băng này, hãy tha thứ cho tôi. Những thí nghiệm được chính phủ tài trợ – họ muốn tạo ra những đứa trẻ đặc biệt, miễn nhiễm với sợ hãi. Nhưng họ không lường trước được điều gì xảy ra khi ta buộc linh hồn con người phải chịu đựng vượt quá giới hạn. Bóng tối sinh ra từ chính nỗi sợ ấy. Và giờ… nó đã có nhận thức.”</em></p>

<p><em>“Tôi thấy nó... trong gương. Nó dùng hình ảnh của tôi để điều khiển bọn trẻ. Và giờ... tôi không biết mình còn là ai nữa.”</em></p>

<p>Bỗng nhiên, từ tấm gương ở góc phòng, một bóng đen lóe lên. Nam và Phúc quay lại. Trong gương, là hình ảnh cả hai – nhưng phía sau là một bóng người đội nón bác sĩ, không có mặt, chỉ là khoảng trống đen ngòm.</p>

<p>“Chạy!” – Phúc hét lên.</p>

<p>Họ lao lên cầu thang, cửa tầng trệt giờ đã mở toang. Nhưng ngôi nhà dường như đang co lại – hành lang dài thêm, tường đổi chỗ, và những tiếng cười khúc khích vọng lại từ mọi phía.</p>

<p>Phúc ngã xuống, chân bị một sợi dây từ đâu siết lấy. Anh gào lên: “Nam! Đừng quay lại! Chạy đi!”</p>

<p>Nam dừng lại trong tích tắc. Anh muốn cứu bạn mình, nhưng rồi… nhìn thấy từ gương trên tường: Phúc đã bị lôi xuống tầng hầm, kéo vào bóng tối, và cánh cửa đóng sập lại.</p>

<p>Nam không còn lựa chọn. Anh lao thẳng ra ngoài cửa chính – nhưng ngôi nhà vẫn chưa buông tha.</p>

<p>Khi Nam bước ra đến thềm hiên, sương mù dày đặc quấn lấy cơ thể anh. Tiếng thì thầm vọng bên tai: <em>“Ngươi là kẻ cuối cùng. Ngươi nhớ chưa? Ngươi từng là một trong bọn ta…”</em></p>

<p>Hình ảnh mờ ảo ùa về trong đầu: căn phòng trắng, tiếng la hét của những đứa trẻ, những giấc mơ không tên, và đôi mắt đen trống rỗng của bác sĩ Hoàng – người từng đứng trước Nam khi anh còn là một đứa trẻ năm tuổi.</p>

<p>Nam gào lên: “Tôi không thuộc về các người!”</p>

<p>Và rồi… ánh sáng. Một tia nắng đầu tiên sau cơn mưa xuyên qua tầng mây xám, chiếu thẳng vào cửa sổ lớn của ngôi biệt thự.</p>

<p>Ngôi nhà rên rỉ. Gạch đá nứt vỡ. Các cửa sổ vỡ tung, và từ trong các khe nứt, những luồng khói đen tuôn ra, kêu lên thảm thiết rồi tan biến như chưa từng tồn tại.</p>

<p>Nam ngã quỵ trước hiên nhà, thở dốc. Trời đã sáng.</p>

<p>Người dân địa phương phát hiện ra anh sáng hôm sau, lang thang trên đồi, người đầy thương tích nhưng sống sót. Khi được hỏi chuyện gì đã xảy ra, anh chỉ lắc đầu: “Không ai sẽ tin… và không ai nên quay lại đó nữa.”</p>

<p><strong>Một tháng sau</strong>, ngôi biệt thự bị phá bỏ. Nhưng đêm nào trời có sương, người ta vẫn nghe thấy tiếng trẻ con cười khúc khích vọng lên từ lòng đất đồi thông…</p>

<p><em>Chỉ một người sống sót. Nhưng ký ức... sẽ không bao giờ chết.</em></p>
',
        '2025-04-27 19:39:00.000000');

INSERT INTO story
(story_id, release_status, story_title, story_description, user_id, language, created_time, cover_image_uri)
VALUES ('c4b3f8e4-2453-4f5b-9f85-6b839bb7e453',
        true,
        'Linh Hồn Nữ Sinh Chết Oan',
        'Vào một đêm tối trời, tại một ngôi trường cổ kính, câu chuyện về một nữ sinh tên Lan, người đã chết oan dưới tay bạn học cũ, bắt đầu được kể lại. Linh hồn của Lan không thể siêu thoát, và cô ấy bắt đầu tìm cách trả thù những kẻ đã gây ra cái chết của mình. Những ai đã từng đối xử tàn nhẫn với Lan đều phải trả giá, và một chuỗi những cái chết bí ẩn liên tiếp xảy ra.',
        '061460f1-45fd-40a8-b243-5da3f0f35523',
        'vi',
        '2025-04-27 20:00:00.000000'
           , '/uploads/sample_book_cover/linh_hon_nu_sinh_chet_oan.png');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('ec4ba948-ee0d-44d2-bb65-ca82176b271d',
        1,
        'Bóng Ma Trong Phòng Học',
        'c4b3f8e4-2453-4f5b-9f85-6b839bb7e453',
        '<p>Trường Trung học Nguyễn Trãi nằm lặng lẽ bên sườn đồi, nơi sương mù giăng kín mỗi sáng sớm và hoàng hôn nhuộm đỏ như máu. Ngôi trường có tuổi đời gần 80 năm, với những dãy nhà cổ kính, tường gạch đã rêu phong và lớp học cũ kỹ mùi ẩm mốc. Nhưng điều khiến học sinh truyền tai nhau không phải là lịch sử lâu đời, mà là một cái tên: Lan.</p>

        <p>Lan từng là học sinh lớp 12A2, cô gái nhút nhát, hiền lành nhưng luôn bị bạn bè cô lập vì nghèo, ít nói và thường mặc đồng phục cũ. Những trò đùa ác ý, những lời nói xỉa xói, cả những hành động bạo lực học đường đều đổ lên đầu cô như một trò tiêu khiển tập thể. Cô lặng lẽ chịu đựng, không ai đứng về phía cô. Và rồi, một ngày mưa lớn cách đây hai năm, Lan được phát hiện đã chết trong nhà kho cũ phía sau dãy nhà B, nơi không ai lui tới.</p>

        <p>Cảnh sát kết luận đó là tự tử. Nhưng học sinh thì thầm với nhau rằng, gương mặt cô khi chết vẫn còn vương lệ và ánh mắt đầy uất hận. Kể từ đó, mỗi năm vào khoảng thời gian đó, có người thấy bóng áo trắng lướt qua hành lang lớp 12A2 lúc nửa đêm. Tiếng khóc nghẹn ngào vọng lên từ nhà kho cũ. Những lời đồn đại lan nhanh, nhưng rồi bị lãng quên khi lứa học sinh mới lên thay.</p>

        <p>Cho đến đêm hôm nay. Minh – học sinh lớp 12A2, cùng nhóm bạn gồm Vy, Dũng và Huy – ở lại học nhóm muộn để chuẩn bị cho kỳ thi cuối kỳ. Họ chọn phòng học 12A2 vì “sóng điện thoại mạnh hơn”. Minh là người từng học cùng Lan, nhưng chưa bao giờ nhớ đến cô… cho đến tối nay.</p>

        <p>Khoảng 9 giờ tối, cả nhóm quyết định nghỉ giải lao. Dũng ra hành lang hút thuốc, Vy và Huy đi mua nước, chỉ còn Minh ở lại lớp học. Bỗng nhiên, đèn nhấp nháy. Quạt trần quay chậm lại rồi ngừng hẳn. Minh lẩm bẩm chửi thề, định đứng dậy ra ngoài thì… cửa lớp đóng sầm lại.</p>

        <p>Một hơi lạnh phả ra từ phía sau gáy khiến Minh rùng mình. Cậu quay lại – không có ai. Nhưng trên bảng, giữa ánh sáng lập lòe, dòng chữ “TẠI SAO CHÚNG MÀY KHÔNG AI CỨU TAO?” hiện lên rõ ràng bằng phấn trắng, run rẩy như được viết bằng tay người đang run sợ.</p>

        <p>Minh hét toáng lên, nhưng không ai nghe thấy. Cậu cố đẩy cửa nhưng nó bị khóa chặt. Trên cửa kính phản chiếu… là bóng một cô gái mặc áo dài trắng, tóc xõa dài, mắt đen ngòm và hai dòng máu chảy từ khóe miệng. Lan. Cô đứng ngay sau cậu.</p>

        <p>Tiếng cười khúc khích văng vẳng trong lớp học. Đèn vụt tắt hoàn toàn. Khi Vy và Huy trở lại, họ thấy Minh ngồi gục đầu trên bàn, tay siết chặt cây bút gãy làm đôi. Ánh mắt Minh trống rỗng, và trên bảng chỉ còn lại dòng chữ: <em>"Trò chơi bắt đầu rồi."</em></p>',
        '2025-04-27 20:05:00.000000');


INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('f23822f7-d3bb-47ae-881a-40b2a1cb8f2c',
        2,
        'Tiếng Thì Thầm Trong Gió',
        'c4b3f8e4-2453-4f5b-9f85-6b839bb7e453',
        '<p>Sau cái chết bất ngờ của Minh, ngôi trường như bị phủ bóng u ám. Ban giám hiệu cho rằng cậu tự tử vì áp lực học tập, nhưng bạn bè thân thiết biết Minh không phải người yếu đuối như vậy. Cái chết ấy để lại quá nhiều nghi vấn – ánh mắt trống rỗng, dòng chữ kỳ lạ trên bảng, và đặc biệt là… nỗi sợ hãi hiện rõ trên gương mặt cậu lúc chết.</p>

        <p>Vy – người bạn thân nhất của Minh – không thể ngủ được suốt nhiều đêm sau đó. Trong đầu cô luôn vang vọng tiếng cười lạnh lẽo tối hôm đó, cùng hình ảnh dòng chữ “Trò chơi bắt đầu rồi” không biết ai đã viết. Cô bắt đầu lục lại ký ức về Lan – cô gái từng học cùng lớp, từng bị bắt nạt tàn nhẫn ngay trong chính căn phòng học này.</p>

        <p>Vy từng là một trong số những người đã quay mặt làm ngơ khi Lan bị Dũng đổ nước vào cặp, bị Huy xô ngã trong sân trường, hay khi những lời nói cay nghiệt được tung ra như trò đùa. Cô nhớ rõ ánh mắt Lan nhìn mọi người – không phải oán hận, mà là tuyệt vọng đến ám ảnh. Và giờ đây, dường như Lan đã trở lại, mang theo nỗi căm hận từ cõi chết.</p>

        <p>Đêm thứ ba sau đám tang Minh, Vy quyết định quay lại lớp 12A2 một mình. Cô muốn kiểm chứng liệu có điều gì mà chỉ mình cô nhận ra, hay mọi thứ chỉ là tưởng tượng. Gió đêm lùa qua khung cửa sổ vỡ khiến rèm cửa tung bay như bàn tay ma quái vẫy gọi. Phòng học tối om, chỉ còn ánh đèn pin nhỏ từ điện thoại Vy chiếu lờ mờ.</p>

        <p>Cô tiến đến bảng đen. Không có dòng chữ nào. Không tiếng cười. Không gì cả. Nhưng khi vừa quay lưng rời đi, một cơn gió lạnh thốc qua làm cửa sổ đập mạnh. Và rồi, cô nghe thấy tiếng thì thầm – rất khẽ, như gió nhưng mang âm sắc của tiếng người: <em>“Vy… mày nhớ tao không?”</em></p>

        <p>Vy quay phắt lại. Không ai cả. Nhưng trên bảng, dòng chữ vừa mới biến mất lại hiện lên: <strong>“Không ai thoát khỏi tội lỗi.”</strong> Mực vẫn còn tươi, nhỏ từng giọt xuống sàn như máu.</p>

        <p>Cô hoảng loạn bỏ chạy. Trên đường về, qua hành lang tầng ba, Vy nghe tiếng bước chân theo sau mình – đều đặn, chậm rãi, vang lên trong đêm tối. Cô quay đầu – không ai cả. Nhưng bóng dáng một nữ sinh mặc áo dài trắng lướt qua hành lang phía xa. Mái tóc dài che khuất mặt, chân không chạm đất.</p>

        <p>Vy trốn vào phòng y tế, run rẩy gọi cho Huy. Nhưng sóng yếu, cuộc gọi bị ngắt. Cô bật đèn pin, soi quanh. Trên giường bệnh, một chiếc cặp học sinh cũ nằm im lìm. Trên đó là thẻ tên: <em>“Nguyễn Thị Lan – 12A2.”</em></p>

        <p>Vy hét lên và ngất lịm. Khi tỉnh dậy, cô đang nằm trong bệnh viện. Huy kể rằng tìm thấy cô ngất xỉu ở hành lang tầng hai, không có chiếc cặp nào cả. Nhưng trong túi áo Vy – có một mảnh giấy học sinh xé từ vở, trên đó ghi: <strong>“Tiếp theo là ai?”</strong></p>',
        '2025-04-28 20:10:00.000000');


INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('c4cc65be-27ad-4fa9-a962-27789ceeee83',
        3,
        'Cái Chết Trong Nhà Vệ Sinh',
        'c4b3f8e4-2453-4f5b-9f85-6b839bb7e453',
        '<p>Sau đêm kinh hoàng đó, Vy xin nghỉ học một tuần. Nhưng sự vắng mặt của cô không làm nguôi đi bầu không khí kỳ lạ bao trùm ngôi trường. Tin đồn về cái chết của Minh bắt đầu lan truyền khắp nơi – có người nói cậu bị ma ám, có kẻ đồn thổi rằng lớp 12A2 bị nguyền rủa. Nhưng hầu hết học sinh vẫn cố gắng coi như không có chuyện gì xảy ra.</p>

        <p>Chỉ riêng Huy – một trong những kẻ từng tham gia bắt nạt Lan nhiều nhất – lại cảm thấy bất an. Dù ngoài mặt vẫn tỏ ra bình thường, bên trong Huy liên tục gặp ác mộng. Trong mơ, cậu thấy mình bị nhốt trong lớp học, xung quanh là bóng tối, và tiếng khóc ai oán vang vọng. Một lần, cậu còn nghe thấy giọng nói yếu ớt: <em>“Tại sao các người lại làm thế với tôi…”</em></p>

        <p>Sáng hôm đó, Huy đến lớp với đôi mắt thâm quầng vì mất ngủ. Giờ ra chơi, cậu vào nhà vệ sinh ở cuối dãy – nơi vốn ít người lui tới. Vừa mở cửa, cậu thấy gương mặt mình trên gương đã nhòe nhoẹt, méo mó một cách kỳ dị. Khi cố gắng lau đi, bàn tay lạnh toát nào đó từ phía sau chạm vào cổ cậu khiến Huy giật mình quay lại – không ai cả.</p>

        <p>Huy vội vã quay người, nhưng cánh cửa đột nhiên đóng sập lại. Đèn chớp liên tục. Không gian lạnh buốt. Và rồi… tiếng nước nhỏ giọt vang lên đều đều như nhịp đồng hồ tử thần. Cậu bắt đầu la hét, đập mạnh vào cửa. Nhưng vô ích.</p>

        <p>Gương vỡ. Một dòng máu chảy ra từ bồn rửa tay – đỏ tươi, tanh nồng. Trên tường, bằng thứ chất lỏng đó, dòng chữ hiện ra từng nét một như có bàn tay vô hình viết lên: <strong>“Tôi chưa tha cho mày.”</strong></p>

        <p>Không ai nghe thấy tiếng hét cuối cùng của Huy. Cho đến khi tiếng trống vào lớp vang lên, một học sinh đi ngang qua thì phát hiện cửa nhà vệ sinh bị khóa từ bên trong. Khi thầy cô phá cửa vào, cảnh tượng bên trong khiến tất cả bàng hoàng: Huy nằm sõng soài dưới sàn, mặt cắt không còn giọt máu, đôi mắt trợn trừng như nhìn thấy thứ gì đó kinh khủng trước khi chết.</p>

        <p>Cái chết được kết luận là… đột tử. Nhưng những người có mặt đều biết rằng, trên gương vỡ vẫn còn in hằn dấu bàn tay nhỏ nhắn bằng máu. Bên trong túi áo Huy, người ta tìm thấy một mẩu giấy nhỏ nhàu nát, chỉ có một dòng chữ nguệch ngoạc:</p>

        <p><em>“Tôi nhớ rõ từng khuôn mặt.”</em></p>

        <p>Trường bắt đầu cấm học sinh đi một mình. Nhưng không ai dám nói gì, vì sâu trong tim mỗi người từng liên quan đến Lan… đều hiểu: cái chết của Huy chỉ mới là bắt đầu.</p>',
        '2025-04-28 20:25:00.000000');


INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('d3e2b2a3-7b29-4a98-b40e-e6b844cb24e4',
        4,
        'Tiếng Gọi Từ Giếng Cũ',
        'c4b3f8e4-2453-4f5b-9f85-6b839bb7e453',
        '<p>Sau cái chết rùng rợn của Huy, cả trường chìm trong nỗi sợ hãi mơ hồ. Những học sinh năm cuối bắt đầu nhìn nhau với ánh mắt nghi ngờ, thì thầm về "lời nguyền" của Lan. Những người từng bắt nạt cô không ai dám ở lại trường một mình. Riêng Trâm – người từng là bạn thân nhưng cũng quay lưng với Lan – lại tỏ ra thờ ơ. Cô cho rằng đây chỉ là sự trùng hợp và trò bịp bợm.</p>

        <p>Trâm từng là người đầu tiên kết thân với Lan khi cô chuyển đến. Nhưng khi Lan trở thành mục tiêu bắt nạt, Trâm đã chọn im lặng. Tệ hơn, cô còn góp phần quay video lan truyền khiến Lan bị tổn thương sâu sắc. Dù bên ngoài cô luôn cười nói, trong lòng vẫn mang một vết nhơ âm ỉ – thứ cô chôn giấu suốt hai năm qua.</p>

        <p>Vào một buổi chiều, khi trời chuyển giông, Trâm được phân công ở lại dọn đạo cụ sân khấu cùng nhóm trực nhật. Nhưng các bạn nhanh chóng về sớm vì cơn mưa lớn sắp đến. Trâm một mình đi qua hành lang cũ, rồi bỗng nghe thấy tiếng gọi yếu ớt vang lên từ phía sau sân trường:</p>

        <p><em>“Trâm... Trâm ơi...”</em></p>

        <p>Cô quay lại, không thấy ai. Tiếng gọi lại vang lên, lần này rõ hơn, dẫn cô tới phía giếng nước cũ – nơi mà theo lời kể, Lan từng hay đến đọc sách. Trâm cố gắng trấn an bản thân, cho rằng đó là trò đùa. Nhưng khi tiến lại gần, cô thấy tấm nắp giếng đã bị mở ra từ lúc nào.</p>

        <p>Cô cúi xuống nhìn, thì bỗng từ lòng giếng, một cánh tay trắng toát vươn lên nắm chặt lấy cổ tay cô. Trâm gào thét, cố rút tay ra nhưng vô ích. Một lực kéo mạnh khiến cô loạng choạng, nửa thân trên rơi xuống giếng. Gương mặt Lan xuất hiện trong làn nước sâu thẳm – mái tóc dài, đôi mắt vô hồn và nụ cười méo mó ám ảnh. Cô thì thầm:</p>

        <p><strong>“Bạn thân ơi... sao lại bỏ rơi tôi?”</strong></p>

        <p>Tiếng hét của Trâm vang lên trong màn mưa, nhưng chẳng ai nghe thấy. Khi mưa tạnh, bảo vệ phát hiện chiếc khăn choàng cổ của Trâm rơi bên cạnh giếng, còn cô thì biến mất không dấu vết. Giếng được phong tỏa. Cảnh sát đến điều tra nhưng không tìm thấy gì ngoài dấu trượt tay bám đầy bùn đất và vết máu nhạt nhòa trên thành giếng.</p>

        <p>Những học sinh từng thân với Trâm bắt đầu hoang mang. Một người bạn thì thào: <em>“Lan... đang bắt từng người một...”</em></p>

        <p>Không khí trong trường chuyển dần sang ngột ngạt, u ám. Sự việc không còn là trùng hợp – mà là một lời nhắn nhủ rợn người từ thế giới bên kia: <strong>Tội lỗi phải trả giá.</strong></p>',
        '2025-04-28 22:10:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('ab7fe2b3-d911-4e70-bf47-59dfdf1eb431',
        5,
        'Bản Tường Trình Bị Xé Rách',
        'c4b3f8e4-2453-4f5b-9f85-6b839bb7e453',
        '<p>Thầy Lâm – giáo viên chủ nhiệm cũ của lớp Lan – là người ngoài mặt luôn mẫu mực, công minh, nhưng thực chất lại là kẻ hèn nhát, từng bỏ qua nhiều lần Lan bị bắt nạt. Trong ngày Lan chết, chính thầy là người giữ bản tường trình cuối cùng mà cô viết – một lá thư cầu cứu ghi rõ tên những kẻ đã khiến cô rơi vào tuyệt vọng. Thế nhưng, thay vì đưa lên Ban giám hiệu, thầy Lâm đã xé nó đi để "tránh làm lớn chuyện".</p>

        <p>Suốt hai năm qua, thầy sống với cảm giác tội lỗi ngấm ngầm, nhưng luôn biện minh rằng mình chỉ làm đúng để bảo vệ danh tiếng trường. Khi Huy và Trâm chết, thầy bắt đầu cảm thấy bất an. Mỗi đêm đều nghe thấy tiếng gõ cửa văn phòng khi đã khóa chặt, tiếng bước chân vọng lại từ hành lang trống rỗng.</p>

        <p>Đêm hôm ấy, khi ở lại soạn đề thi, thầy nghe thấy tiếng giấy bị vò nát vang lên từ ngăn kéo. Mở ra, ông chết điếng khi thấy một mảnh giấy cũ nhàu nát – chính là bản tường trình năm nào – giờ đây dính máu khô loang lổ. Trên đó, nét chữ của Lan hiện rõ:</p>

        <p><em>“Thầy, tại sao thầy im lặng?”</em></p>

        <p>Thầy Lâm ném mảnh giấy xuống sàn, hốt hoảng rút điện thoại gọi người. Nhưng máy không có sóng. Đèn trong văn phòng chớp tắt liên hồi. Cửa bật mở dù không có gió. Gương mặt Lan hiện lên trong gương cửa kính, đôi mắt đẫm lệ, mái tóc rũ rượi phủ kín một bên má. Cô không nói, chỉ nhìn thầy bằng ánh mắt uất ức đến ghê người.</p>

        <p>Thầy ngã lùi lại, run rẩy. Cố mở cửa chạy ra ngoài, nhưng mọi lối đều như vô hình đóng sập lại. Trên bảng, phấn tự động viết từng dòng:</p>

        <p><strong>“Thầy đã chối bỏ sự thật.”<br>“Thầy đã để tôi chết.”<br>“Giờ đến lượt thầy chịu phán xét.”</strong></p>

        <p>Tiếng chuông báo cháy bất ngờ vang lên. Khói từ đâu tràn ngập phòng. Người bảo vệ lao đến phá cửa thì thấy căn phòng trống không, chỉ có đôi kính gãy và chiếc áo khoác của thầy rơi lại trên sàn. Bên dưới bàn làm việc, bản tường trình nằm chình ình, sạch sẽ như mới viết.</p>

        <p>Ngày hôm sau, trường thông báo thầy Lâm mất tích. Không ai tìm thấy thi thể, cũng không có dấu hiệu bị bắt cóc. Nhưng từ hôm đó trở đi, mỗi đêm 12 giờ, ánh đèn trong văn phòng lại tự động bật sáng, dù đã ngắt nguồn điện.</p>

        <p>Những người biết chuyện bắt đầu tin rằng Lan không chỉ trở lại vì thù hận cá nhân – mà còn để vạch mặt tất cả những kẻ liên đới đến cái chết oan ức của mình. Và giờ đây, mọi tội lỗi bị che giấu đang lần lượt bị phơi bày – từng người một, không ai thoát được.</p>',
        '2025-04-28 23:10:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('e9c93e87-1fd1-4c72-9147-3706575f5894',
        6,
        'Lời Nguyền Bất Tận',
        'c4b3f8e4-2453-4f5b-9f85-6b839bb7e453',
        '<p>Phương – thủ lĩnh nhóm bắt nạt Lan – là người cuối cùng trong danh sách những kẻ đáng phải trả giá. Phương là học sinh nổi bật của trường, được mọi người ngưỡng mộ vì sự xinh đẹp và tài năng. Nhưng ít ai biết, phía sau lớp vỏ hào nhoáng đó là một kẻ lạnh lùng, tàn nhẫn, luôn tìm cách hạ bệ người khác để khẳng định vị trí của mình. Cô ta từng là người đứng sau những hành động bắt nạt mà Lan phải chịu đựng suốt hai năm qua.</p>

        <p>Đêm ấy, khi tất cả học sinh đã về hết, Phương vẫn ở lại trường để chuẩn bị cho cuộc thi. Đột nhiên, cô cảm thấy trong không gian lạnh lẽo có gì đó không ổn. Cánh cửa phòng học tự động mở ra. Phương đi qua hành lang, trong lòng thấp thỏm lo sợ. Tiếng bước chân cô vọng lại từ những bức tường hoang lạnh, dường như có ai đó đang theo dõi cô. Nhưng khi quay lại, chỉ có bóng tối và sự im lặng.</p>

        <p>Đến gần phòng thí nghiệm, Phương nghe thấy một âm thanh lạ phát ra từ bên trong. Cô mở cửa. Bên trong, ánh sáng mờ ảo từ bóng đèn huỳnh quang yếu ớt chiếu lên chiếc bàn làm việc. Trên bàn có một cuốn sổ cũ, được đặt ngay ngắn, như thể đang chờ đợi ai đó. Phương bước đến gần, lòng đầy sự tò mò.</p>

        <p>Khi cô mở cuốn sổ ra, một làn gió lạnh thổi qua. Mắt cô mở to khi nhận ra đó chính là bản tường trình của Lan, một lần nữa xuất hiện trước mắt. Nhưng lần này, không phải chỉ là những dòng chữ, mà là lời nguyền chết chóc viết bằng máu:</p>

        <p><strong>“Tôi đã chết vì bạn. Bạn sẽ không thể thoát khỏi tôi.”</strong></p>

        <p>Phương hoảng hốt ngã lùi về phía sau. Mặt cô trắng bệch khi nhìn thấy bóng dáng Lan xuất hiện trong căn phòng. Lan đứng đó, mái tóc dài rũ rượi, đôi mắt đầy oán hận nhìn thẳng vào Phương. Phương định quay chạy, nhưng đôi chân cô như bị đổ bê tông, không thể nhúc nhích.</p>

        <p><em>“Tại sao? Tại sao lại đối xử với tôi như thế? Tôi đã làm gì sai?”</em> – Lan thì thào, giọng đầy đau đớn.</p>

        <p>Phương gào lên, nhưng không một âm thanh nào thoát ra từ miệng. Bóng tối bao trùm lấy cô. Cô cảm thấy như bị kéo xuống đất, đất đen và lạnh như hố mộ sâu thẳm. Phương vẫy vùng, cố gắng đứng dậy, nhưng không thể. Mỗi lần cố thoát ra, cô lại chìm sâu hơn.</p>

        <p>Cuối cùng, Phương chỉ kịp hét lên một tiếng duy nhất trước khi chìm vào bóng tối. Trong phút chốc, toàn bộ cơ thể cô biến mất, để lại chỉ một chiếc điện thoại nằm im trên sàn, màn hình sáng lên với dòng tin nhắn cuối cùng:</p>

        <p><em>“Cảnh báo! Nguy hiểm.”</em></p>

        <p>Sáng hôm sau, khi các học sinh đến trường, Phương không xuất hiện. Chiếc điện thoại của cô được tìm thấy trong phòng thí nghiệm, nhưng không có dấu vết của cô đâu cả. Điều kỳ lạ là, trong số những thông tin trên điện thoại, tất cả các tin nhắn liên quan đến Lan đều bị xóa sạch. Chỉ còn lại một bức ảnh của Phương, mặt mày tái nhợt, đôi mắt trừng lớn như thể vừa chứng kiến điều gì đó không thể tin nổi.</p>

        <p>Chuyện này khiến cả trường càng hoang mang hơn bao giờ hết. Những lời đồn đoán về lời nguyền của Lan càng trở nên mạnh mẽ. Liệu còn ai trong số những kẻ đã hại cô có thể thoát khỏi sự trả thù của linh hồn oan nghiệt này? Câu trả lời sẽ sớm được hé lộ trong đêm tối kế tiếp...</p>',
        '2025-04-29 00:20:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('7b14b998-9b7e-456a-a74c-cd1b0207c6e1',
        7,
        'Đêm Tối Cuối Cùng',
        'c4b3f8e4-2453-4f5b-9f85-6b839bb7e453',
        '<p>Đêm cuối cùng, khi ánh trăng chỉ là một vệt sáng nhạt trong bầu trời đen đặc, trường học chìm trong sự yên lặng đáng sợ. Những cái chết bí ẩn đã khiến mọi người không dám tiếp tục quay lại nơi này. Những kẻ liên quan đến Lan đều đã vướng phải lời nguyền, nhưng không ai biết liệu sự trả thù của cô sẽ dừng lại hay không.</p>

        <p>Minh – người duy nhất còn sống sót trong nhóm bạn của Lan – trở lại trường vào đêm hôm đó, với hy vọng có thể tìm ra lời giải cho cái chết của bạn bè và những sự kiện kỳ lạ xảy ra. Trong lòng Minh vẫn canh cánh một câu hỏi: liệu Lan có thật sự muốn trả thù tất cả, hay cô chỉ muốn được công nhận sự đau khổ mà cô đã phải chịu đựng?</p>

        <p>Minh bước vào phòng học nơi Lan đã từng ngồi, mắt nhìn quanh, tim đập nhanh. Không khí lạnh lẽo bao trùm khắp nơi. Cái bàn của Lan vẫn còn nguyên, cuốn sổ tay cũ nằm trên đó, mực chữ đã phai, nhưng vẫn có thể nhìn thấy những dòng chữ rành mạch:</p>

        <p><em>“Thầy, tại sao thầy im lặng?”</em></p>

        <p>Minh ngồi xuống, chậm rãi mở cuốn sổ ra. Đột nhiên, một luồng gió lạnh thổi qua, khiến anh run lên. Cánh cửa phòng học tự động đóng lại sau lưng Minh, tạo nên một âm thanh khô khốc. Minh quay lại nhìn, nhưng chẳng thấy gì ngoài bóng tối.</p>

        <p>Bỗng nhiên, những tiếng động lạ vang lên. Âm thanh của bước chân như thể có ai đó đang đi trên nền gạch cứng. Minh ngẩng lên, và trong bóng tối, đôi mắt đỏ rực của Lan chợt lóe sáng. Cô đứng đó, trong bộ đồng phục học sinh cũ, khuôn mặt trông vô cùng thảm thương nhưng cũng đầy phẫn nộ.</p>

        <p><em>“Minh, anh là người duy nhất không làm hại tôi. Nhưng anh vẫn bỏ tôi lại. Anh đã biết tôi chết oan mà chẳng làm gì.”</em></p>

        <p>Minh hoảng hốt, cố tìm cách giải thích. Anh bước về phía Lan, giọng run rẩy:</p>

        <p><em>“Lan, tôi không biết, tôi không thể làm gì để cứu bạn. Tôi… tôi xin lỗi…”</em></p>

        <p>Lan im lặng nhìn Minh. Một ánh sáng yếu ớt lóe lên từ đôi mắt cô, và rồi mọi thứ xung quanh Minh bắt đầu thay đổi. Những bóng tối cuộn lại xung quanh anh, trói buộc anh trong vòng xoáy vô hình. Minh ngã quỵ xuống sàn, và trước khi kịp nói thêm lời nào, Lan tiến lại gần, gương mặt cô giờ đây gần như là một lớp bóng tối đáng sợ. Những lời cuối cùng của Lan cất lên như một lời nguyền không thể xóa bỏ:</p>

        <p><strong>“Anh đã không cứu tôi. Anh sẽ phải sống với tội lỗi này mãi mãi.”</strong></p>

        <p>Và rồi, Minh biến mất trong bóng tối, chẳng để lại dấu vết gì. Ngày hôm sau, mọi người trong trường chỉ thấy chiếc ghế trống, nơi Minh từng ngồi. Không ai biết Minh đi đâu, nhưng câu chuyện về sự trả thù của Lan vẫn được kể lại, vang vọng mãi trong những hành lang vắng vẻ.</p>

        <p>Trường học trở thành một nơi bị bỏ hoang, không ai dám bước vào nữa. Câu chuyện về Lan – nữ sinh chết oan – vẫn là một bài học cảnh tỉnh, một lời nhắc nhở rằng sự tàn nhẫn không bao giờ được bỏ qua, và rằng một khi sự oán hận đã lên tới đỉnh điểm, nó sẽ khiến mọi thứ phải trả giá.</p>

        <p>Và trong đêm tối, ánh sáng từ những ngọn đèn cũ lại chập chờn, như thể Lan vẫn còn ở đó, trong bóng tối, chờ đợi những kẻ tiếp theo phải trả giá cho tội lỗi của mình.</p>',
        '2025-04-30 01:30:00.000000');


-- Insert Story
INSERT INTO story
(story_id, release_status, story_title, story_description, user_id, language, created_time, cover_image_uri)
VALUES ('2a9f7b84-5cb4-4b45-a951-6e432fcdce42',
        true,
        'Linh Hồn Người Lính Trở Về Quê Hương',
        'Trong chiến tranh, một người lính Việt Nam đã hy sinh trong một trận đánh ác liệt. Linh hồn của anh không thể siêu thoát, mãi quay quắt tìm đường trở về quê hương để gặp lại gia đình, nhưng bóng tối đã bao trùm, anh không thể thoát khỏi nỗi đau khôn nguôi của cái chết oan. Anh bắt đầu một hành trình kinh hoàng từ chiến trường trở về nhà, đối diện với những bóng ma, những nỗi sợ hãi và sự ám ảnh của chiến tranh.',
        '061460f1-45fd-40a8-b243-5da3f0f35523',
        'vi',
        '2025-04-27 20:30:00.000000',
        '/uploads/sample_book_cover/linh_hon_nguoi_linh_tro_ve_que_huong.png');

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
(story_id, release_status, story_title, story_description, user_id, language, created_time, cover_image_uri)
VALUES ('7b8d9d70-bf6f-48ac-96f2-33a330c6fae2',
        true,
        'Linh Hồn Người Bán Bánh Giò',
        'Một người bán bánh giò tội nghiệp, ngày ngày ngồi bán hàng tại một con hẻm nhỏ, sống cuộc sống nghèo khó. Nhưng một ngày, anh ta bị giết chết dã man bởi những tên nghiện ma túy. Linh hồn anh không thể siêu thoát, mãi ám lấy con hẻm nơi anh đã nằm xuống, khiến cho mọi người qua lại cảm thấy sợ hãi và ám ảnh. Đến nay, không ai dám lại gần nơi đó vào ban đêm.',
        '061460f1-45fd-40a8-b243-5da3f0f35523',
        'vi',
        '2025-04-27 21:00:00.000000', '/uploads/sample_book_cover/linh_hon_nguoi_ban_banh_gio.webp');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('c8bb7a7d-fd1f-41b9-b2f1-1c55e11c313f',
        1,
        'Cuộc Sống Nhọc Nhằn',
        '7b8d9d70-bf6f-48ac-96f2-33a330c6fae2',
        '<p>Ngày ngày, anh vẫn ngồi đó, tại con hẻm nhỏ vắng vẻ, nơi mà không mấy ai chú ý đến. Cuộc sống của anh, người bán bánh giò nghèo khó, giản dị nhưng đầy ắp những nỗi lo toan. Mỗi chiếc bánh giò mà anh làm ra đều chứa đựng mồ hôi và nước mắt. Hàng ngày, anh ngồi một mình trong cái không gian u ám, chẳng có ai là bạn, cũng chẳng có ai là người thân. Chỉ có những chiếc bánh giò, và đôi tay mỏi mệt của anh.</p>

        <p>Con hẻm ấy vốn là nơi buôn bán của nhiều người, nhưng không ai chú ý đến anh. Họ chỉ thấy một người đàn ông nghèo, suốt ngày ngồi bán bánh giò mà không hiểu rằng anh có một câu chuyện buồn đằng sau. Anh không bao giờ nói ra, nhưng mỗi lần nhìn vào những chiếc bánh giò, anh lại cảm thấy xót xa. Đó là tất cả những gì anh có để sống sót, là mảnh đời mà anh đã từng mơ ước có thể thay đổi.</p>

        <p>Nhưng không có gì thay đổi. Những tên nghiện ma túy thường xuyên lang thang qua khu phố, chúng không hề có ý định mua bánh giò. Chúng chỉ đến để tìm kiếm những kẻ dễ bị tấn công, và lần này, chúng đã tìm đến anh. Những tên đó đã đến gần, những ánh mắt thèm thuồng nhìn chằm chằm vào túi tiền của anh. Khi anh từ chối đưa tiền, chúng đã dùng dao đâm anh một cách tàn bạo.</p>

        <p>Những vết thương rỉ máu, đôi mắt anh mở to như muốn tìm kiếm sự cứu rỗi, nhưng trong cái con hẻm vắng tanh ấy, không có ai để giúp đỡ. Anh chết trong sự cô đơn, không một lời từ biệt. Máu anh hòa với những chiếc bánh giò mà anh đã làm. Cả khu phố im lặng, như không hề hay biết một người đã ra đi mãi mãi.</p>

        <p>Và từ đó, con hẻm ấy trở thành nơi không ai dám đến vào ban đêm. Những người qua lại bắt đầu cảm nhận một sự kỳ lạ, một điều gì đó không thể giải thích được. Một cảm giác lạnh lẽo, nặng nề bao trùm không gian. Cứ mỗi đêm, khi màn đêm buông xuống, một bóng hình nhạt nhòa của anh lại hiện lên, đứng lặng lẽ bên lề con hẻm. Mắt anh vẫn mở to, đầy oán hận, không thể siêu thoát.</p>',
        '2025-05-05 02:00:00.000000');


INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('d0e87be6-bfcd-4bfa-8de1-0904536a36e4',
        2,
        'Linh Hồn Không Siêu Thoát',
        '7b8d9d70-bf6f-48ac-96f2-33a330c6fae2',
        '<p>Không ai biết được, nhưng linh hồn anh vẫn không thể siêu thoát. Sau cái chết oan nghiệt, anh không thể rời khỏi con hẻm nơi mình đã sống, nơi mà anh đã trải qua những tháng ngày vất vả, tủi nhục. Anh không muốn ra đi như vậy, và cũng không thể quên được cái cảm giác của sự đau đớn, của cái chết tàn bạo do những tên nghiện ma túy gây ra.</p>

        <p>Ban ngày, mọi thứ có vẻ bình thường, nhưng khi màn đêm buông xuống, mọi chuyện lại khác. Những người qua lại con hẻm này thường xuyên cảm nhận được một cảm giác lạnh lẽo đến kỳ lạ. Dường như không khí trở nên đặc quánh, và bóng tối bao trùm lấy mọi thứ. Nếu ai đó dừng lại lâu, họ có thể cảm nhận được một cái nhìn dõi theo mình từ đâu đó trong bóng tối. Những bước chân không ai thấy nhưng lại nghe rõ ràng, những tiếng thở dài bất ngờ vang lên giữa không gian vắng lặng.</p>

        <p>Vào một đêm, khi một người đi ngang qua con hẻm, anh ta đột nhiên cảm thấy lạnh sống lưng. Bất chợt, anh ta nhìn thấy một bóng hình lạ đứng ở cuối con hẻm. Đó là một người đàn ông, tóc rối bời, quần áo rách rưới, đôi mắt sáng rực như ánh đèn ma quái. Anh ta đứng đó, không cử động, nhưng đôi mắt thì dõi theo người qua lại như thể muốn nói điều gì. Người qua đường sợ hãi, bước chân run rẩy, nhưng không thể thoát khỏi cảm giác bị nhìn chăm chăm.</p>

        <p>Cứ thế, linh hồn anh tiếp tục lởn vởn trong con hẻm. Người đi qua thường xuyên nghe thấy tiếng bước chân của một ai đó phía sau lưng mình, dù nhìn lại chẳng thấy ai. Họ nghe thấy tiếng lách cách, tiếng dao kéo, tiếng của những chiếc bánh giò rơi xuống đất. Cảm giác ấy khiến họ không dám quay lại, không dám đến gần con hẻm vào ban đêm nữa. Nhưng mỗi lần bước qua, họ đều không thể thoát khỏi cảm giác bị ám ảnh. Hình ảnh người bán bánh giò, mắt sáng rực, lặng lẽ theo dõi, cứ hiện lên trong đầu họ.</p>',
        '2025-05-05 02:30:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('a57a99f9-d1c1-420d-bbb8-b30f06a0758f',
        3,
        'Những Cái Chết Bí Ẩn',
        '7b8d9d70-bf6f-48ac-96f2-33a330c6fae2',
        '<p>Sự hiện diện của linh hồn người bán bánh giò không chỉ khiến cho những người qua lại con hẻm cảm thấy ám ảnh, mà còn khiến những kẻ liên quan đến cái chết của anh phải trả giá. Những cái chết bí ẩn bắt đầu xảy ra mà không có lời giải thích hợp lý. Một tên trong nhóm nghiện ma túy, người đã tham gia vào vụ cướp và giết anh, đột nhiên bị tai nạn giao thông. Hắn lái xe lao thẳng vào một chiếc xe tải mà không hề phanh, chết ngay tại chỗ.</p>

        <p>Chuyện chưa dừng lại ở đó. Một kẻ khác trong nhóm nghiện, kẻ đã đâm anh, bị ám ảnh bởi những giấc mơ kỳ lạ. Mỗi đêm, hắn luôn nhìn thấy hình ảnh người bán bánh giò, đôi mắt sáng rực nhìn hắn một cách đầy căm hận. Hắn tỉnh dậy trong cơn mơ hoảng loạn, mồ hôi lạnh toát ra, nhưng không thể thoát khỏi cảm giác kinh hoàng đó. Dần dần, hắn không thể chịu đựng nổi sự ám ảnh và điên loạn. Cuối cùng, hắn đâm đầu vào bức tường trong lúc điên cuồng chạy trốn khỏi hình ảnh ấy.</p>

        <p>Những cái chết kỳ lạ tiếp tục xảy ra và không ai hiểu được tại sao. Những người từng gây ra cái chết cho người bán bánh giò dần dần biến mất khỏi cuộc sống, bị những tai họa khủng khiếp đuổi theo. Những người sống sót trong nhóm tội phạm bắt đầu nhận ra rằng, linh hồn của người bán bánh giò vẫn đang ám ảnh họ, không thể buông tha họ.</p>

        <p>Còn con hẻm thì trở thành một nơi bị bỏ hoang. Không ai dám đến gần vào ban đêm. Những câu chuyện kỳ bí về cái chết của anh, về linh hồn không siêu thoát, đã trở thành một nỗi ám ảnh đối với những người sống ở khu vực này. Và những ai dám bước vào con hẻm vào ban đêm, họ luôn cảm thấy như có ai đó đang theo dõi mình, như có một đôi mắt đang dõi theo mọi hành động của họ.</p>',
        '2025-05-05 03:00:00.000000');

INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('f7bd3f5d-2a34-41bc-8e5d-c4f2efb9d397',
        4,
        'Cái Kết Mở',
        '7b8d9d70-bf6f-48ac-96f2-33a330c6fae2',
        '<p>Mặc dù những cái chết bí ẩn đã liên tục xảy ra, con hẻm nơi người bán bánh giò đã nằm xuống vẫn không hề thay đổi. Những người qua lại vẫn cảm thấy một sự lạnh lẽo kỳ lạ mỗi khi đi qua, nhưng không ai dám dừng lại hay bước vào trong đêm tối. Cảm giác bị theo dõi vẫn luôn hiện hữu, nhưng không ai có thể lý giải được nguyên nhân của những sự kiện kỳ lạ này. Và thế giới này, dường như đã quay lưng lại với những nỗi sợ hãi vô hình ấy.</p>

        <p>Có một đêm, khi màn đêm bao phủ con phố nhỏ, một người đàn ông, tên là Hùng, đã quyết định bước vào con hẻm, bất chấp những lời cảnh báo từ những người dân địa phương. Hùng là một người lạ, mới chuyển đến khu vực này, và tất cả những gì anh biết về con hẻm chỉ là những câu chuyện kỳ bí mà anh nghe được từ những người xung quanh. Anh vốn là một người rất thực tế, luôn tin vào lý trí và khoa học, và không thể chấp nhận những điều không thể giải thích.</p>

        <p>Đêm đó, Hùng đi bộ qua con hẻm một mình. Lúc đầu, anh không cảm thấy có gì đặc biệt, chỉ có không khí là hơi lạnh. Tuy nhiên, khi bước qua giữa hẻm, một cảm giác nặng nề bắt đầu bao trùm lấy anh. Dường như có một điều gì đó theo dõi từng bước đi của anh. Hùng ngoái đầu nhìn lại, nhưng chỉ thấy bóng tối mờ ảo, không có gì rõ ràng. Anh cười thầm và tiếp tục đi về phía trước, cho rằng đó chỉ là trí tưởng tượng của mình.</p>

        <p>Nhưng rồi, một tiếng động nhẹ vang lên từ phía sau lưng anh. Là tiếng bước chân. Hùng dừng lại, cố gắng lắng nghe, nhưng không thấy gì thêm. Anh quay lại, không có ai, chỉ có bóng tối đen đặc. Nhưng ngay khi anh quay người đi tiếp, tiếng bước chân lại vang lên một lần nữa, lần này gần hơn.</p>

        <p>Hùng không thể tin vào tai mình. Anh quay lại, nhìn vào bóng tối phía sau, và cuối cùng, anh thấy một bóng hình nhạt nhòa, mờ mờ ảo ảo. Đó là một người đàn ông, hay một cái bóng, đứng yên lặng trong bóng tối, đôi mắt sáng rực như đèn, nhìn chằm chằm vào anh. Hùng sợ hãi, không thể động đậy, nhưng trong giây lát, bóng hình đó bỗng nhiên biến mất, không còn lại gì ngoài không gian tĩnh lặng.</p>

        <p>Hùng vội vã chạy ra khỏi con hẻm, tim đập thình thịch. Anh không biết mình vừa chứng kiến điều gì, nhưng cảm giác lạnh lẽo ấy vẫn còn đeo bám anh. Anh không dám quay lại con hẻm đó nữa. Tuy nhiên, câu chuyện về người bán bánh giò và linh hồn không siêu thoát của anh vẫn không buông tha Hùng. Anh không thể quên được hình ảnh kỳ lạ đó, không thể lý giải tại sao lại có sự hiện diện của ai đó trong bóng tối.</p>

        <p>Vào những đêm sau đó, Hùng bắt đầu nghe thấy những tiếng thở dài bất ngờ, những tiếng động lạ lùng từ con hẻm, dù anh không bao giờ bước qua đó nữa. Những âm thanh đó như một lời gọi, như một lời mời gọi anh quay lại nơi đó, nhưng anh vẫn không dám. Anh không thể hiểu được sự tồn tại của linh hồn ấy, nhưng có một điều anh biết chắc chắn: linh hồn người bán bánh giò vẫn còn ở đó, không siêu thoát, không thể dứt bỏ.</p>

        <p>Và rồi, câu chuyện không có hồi kết. Những người khác vẫn đi qua con hẻm đó, không ai dám dừng lại. Những cái chết bí ẩn và những hiện tượng kỳ quái vẫn cứ tiếp tục. Linh hồn người bán bánh giò vẫn ở đó, vẫn ám ảnh, không biết bao giờ mới kết thúc. Liệu anh ta có tìm được sự giải thoát cho mình, hay con hẻm ấy sẽ mãi mãi là nơi giam cầm linh hồn của một người đàn ông vô tội? Không ai biết, và có lẽ sẽ không bao giờ biết được.</p>',
        '2025-05-05 04:00:00.000000');


-- Insert Story
INSERT INTO story
(story_id, release_status, story_title, story_description, user_id, language, created_time, cover_image_uri)
VALUES ('3f9a690b-94d7-4c7b-a243-907d0a254a11',
        true,
        'Bảy Tội Lỗi Của Con Người',
        'Một câu chuyện gồm bảy chương, mỗi chương khám phá một trong bảy tội lỗi của con người theo Kinh thánh. Mỗi tội lỗi đều mang một bài học cảnh tỉnh, khiến con người phải đối diện với hậu quả của những hành động xấu xa và không nhân đạo của mình.',
        '061460f1-45fd-40a8-b243-5da3f0f35523',
        'vi',
        '2025-04-27 22:00:00.000000',
        '/uploads/sample_book_cover/bay_toi_loi_cua_con_nguoi.png');

-- Insert Chapter 1: Kiêu Ngạo (Pride)
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('0e62f592-f5f2-4690-a8c5-d5fd1e97b1a1',
        1,
        'Háu ăn – Khi cái miệng không biết no, tâm hồn dần chết đói',
        '3f9a690b-94d7-4c7b-a243-907d0a254a11',
        '<p>Ông Hùng từng là một đầu bếp nổi tiếng, từng có chuỗi nhà hàng danh tiếng khắp Sài Gòn. Nhưng khi về hưu, ông không còn nấu cho ai khác ngoài chính mình. Không còn thực khách, ông bắt đầu nấu ngày ba bữa linh đình chỉ để… ăn một mình. Tủ lạnh nhà ông lúc nào cũng chất đầy nguyên liệu hảo hạng, rượu vang quý, phô mai ngoại, hải sản tươi sống.</p>

<p>“Tôi sống để ăn, không ăn thì sống để làm gì?” – ông thường nói với bất cứ ai hỏi thăm. Dần dà, ông ít ra khỏi nhà, ít giao tiếp, chỉ quanh quẩn giữa bếp và bàn ăn. Cơ thể ông béo phì, di chuyển khó khăn, nhưng ông luôn tìm được lý do để chiều chuộng khẩu vị.</p>

<p>Một ngày, ông bị ngất trong nhà tắm. Bác sĩ chẩn đoán: tiểu đường giai đoạn nặng, gan nhiễm mỡ cấp, nguy cơ nhồi máu cao. “Ông cần phải ăn kiêng nghiêm ngặt, nếu không sẽ không qua nổi mùa đông này.”</p>

<p>Ông Hùng nghe, nhưng trong đầu chỉ nghĩ: “Đời người được bao lâu, không lẽ giờ ăn cháo trắng cầm hơi?”. Ngay khi vừa khỏe lại, ông đặt sushi, bánh ngọt, rượu sake về. Ông nghĩ mình đang sống trọn vẹn, nhưng thực chất là đang chết dần trong khoái cảm của chính mình.</p>

<p>Rồi một đêm mưa, người hàng xóm phát hiện căn nhà ông tối om. Mùi thức ăn thiu bốc lên nồng nặc. Ông Hùng được tìm thấy trên bàn ăn, tay vẫn cầm nửa chiếc đùi gà, mắt mở trừng trừng như chưa kịp no. Trên tường là bức ảnh cũ chụp ông đang cười rạng rỡ giữa dàn nhân viên nhà hàng – người ta nói ông từng là người rất hào phóng, luôn chia sẻ từng bữa ăn với người khác.</p>

<p>Nhưng những năm cuối đời, cái dạ dày của ông đã nuốt trọn mọi điều tốt đẹp: tình thân, sức khỏe, ý nghĩa sống. Ông chết trong cô độc, bao quanh bởi đồ ăn… lạnh tanh.</p>

<p><em>Bài học: Ăn uống là để duy trì sự sống, không phải để lấp đầy khoảng trống tâm hồn. Khi ta để bản năng điều khiển lý trí, lòng tham lam không chỉ giết cơ thể, mà còn giết chết cả những điều đẹp nhất trong ta.</em></p>


<p><em>Bài học: Kiêu ngạo khiến con người không còn nhìn thấy thực tại – mà chỉ thấy hình ảnh vĩ đại trong tưởng tượng. Và đôi khi, chính cái “tôi” đó sẽ nuốt chửng linh hồn họ.</em></p>
',
        '2025-04-27 22:05:00.000000');

-- Insert Chapter 2: Tham lam (Greed)
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('f5781c53-3720-46c1-8c51-8a7b88db66b1',
        2,
        'Tham lam - Vàng không máu',
        '3f9a690b-94d7-4c7b-a243-907d0a254a11',
        '<p>Hòa là một thợ mỏ già sống ở vùng núi đá xa xôi. Suốt gần 30 năm cuộc đời, ông làm việc cần mẫn để kiếm miếng cơm manh áo, không mong gì ngoài sự bình yên. Nhưng mọi thứ thay đổi khi một hôm, trong lúc đào sâu vào lòng đất, ông phát hiện một mạch quặng vàng óng ánh – dường như chưa từng bị ai chạm tới.</p>

<p>Ánh vàng lấp lánh làm tim Hòa đập thình thịch. Thay vì báo cho nhóm khai thác, ông lặng lẽ đánh dấu khu vực và âm thầm đào ban đêm. Vàng nhiều đến mức ông phải giấu trong hộc đá dưới nền nhà, mỗi đêm mang ra đếm và cười như một đứa trẻ.</p>

<p>Tham vọng bắt đầu lớn dần trong lòng ông. Hòa bỏ mặc vợ con, ít giao tiếp với làng xóm, và ngày càng khắc nghiệt với những ai hỏi han về công việc. Ông thuê người lạ đến đào giúp, nhưng sau khi hoàn tất, họ đều biến mất không dấu vết.</p>

<p>Một đêm mưa to, Hòa mơ thấy một người thợ mỏ cũ, khuôn mặt lấm lem bùn đất, mắt trợn ngược. Người đó nói: <em>“Đây không phải là vàng, mà là linh hồn bị giam cầm. Ai chạm vào nó đều phải trả giá.”</em></p>

<p>Hòa tỉnh giấc, mồ hôi nhễ nhại. Nhưng nỗi lo bị phát hiện khiến ông càng đào sâu hơn. Ông tin chỉ cần thêm một ít nữa thôi, ông có thể bỏ lại tất cả và sống như vua ở phương xa.</p>

<p>Đêm định mệnh đến khi ông phá được tầng đá cuối cùng. Một khoang rỗng hiện ra, nơi không phải vàng, mà là những bộ hài cốt đen kịt nằm ngổn ngang. Một bàn tay xương xẩu vươn lên từ bóng tối, nắm lấy chân ông. Cả khoang rung chuyển, và tiếng thì thầm vang lên: <em>“Ngươi đã đánh thức chúng ta… những kẻ bị ngươi tham lam chôn sống.”</em></p>

<p>Dân làng chỉ nghe thấy tiếng la hét vang vọng từ mỏ vào sáng hôm sau. Khi đến nơi, không còn ai – chỉ có chiếc mũ bảo hộ cũ kỹ và một vũng máu nhỏ thấm vào đá. Mạch vàng sau đó cũng biến mất không dấu vết, như thể chưa từng tồn tại.</p>

<p>Từ đó về sau, ai đi qua khu mỏ cũ đều nghe tiếng lạch cạch cuốc xẻng, và tiếng đếm vàng khe khẽ giữa đêm khuya – như tiếng lòng của kẻ mãi mãi không thoát khỏi cái bẫy do chính sự tham lam của mình tạo nên.</p>

<p><em>Bài học: Tham lam biến con người thành tù nhân của chính lòng tham. Càng có nhiều, họ càng khao khát, cho đến khi bị nuốt chửng bởi thứ mà họ nghĩ sẽ giải thoát mình.</em></p>
',
        '2025-04-27 22:10:00.000000');

-- Insert Chapter 3: Giận Dữ (Wrath)
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('7221dfd5-7e76-4c5e-9009-17000c345290',
        3,
        'Dục vọng – Mùi hương của địa ngục',
        '3f9a690b-94d7-4c7b-a243-907d0a254a11',
        '<p>Minh là một chàng trai trẻ làm việc tại một công ty truyền thông nổi tiếng. Ngoại hình điển trai, ăn nói khéo léo và biết cách quyến rũ, anh luôn là tâm điểm trong mắt phái nữ. Nhưng phía sau nụ cười ngọt ngào ấy là một trái tim lạnh lẽo – Minh xem tình yêu như một trò chơi chinh phục, một chiến lợi phẩm để nâng cái tôi của mình lên cao hơn.</p>

<p>Chẳng ai nhớ nổi Minh đã yêu bao nhiêu người. Mỗi lần là một mùi hương khác, một hình bóng khác, rồi kết thúc trong thinh lặng. Anh chỉ quan tâm đến cảm giác chinh phục, đến ánh mắt si mê của người đối diện, và những đêm mù sương không tình yêu.</p>

<p>Cho đến một ngày, Minh gặp cô – một người phụ nữ bí ẩn đến công ty anh phỏng vấn. Cô không đẹp theo tiêu chuẩn thông thường, nhưng ở cô toát lên khí chất lạnh lùng cuốn hút lạ kỳ. Cô tên là Linh.</p>

<p>Minh bắt đầu trò chơi quen thuộc: ánh mắt, cử chỉ, lời khen tinh tế. Nhưng kỳ lạ thay, Linh không phản ứng. Cô chỉ mỉm cười nhẹ, nhìn Minh như thể đọc được hết tâm can anh. Điều đó khiến Minh phát điên. Anh càng say mê, càng khao khát chiếm lấy cô như một chiến lợi phẩm cuối cùng.</p>

<p>Linh đồng ý đi chơi cùng anh sau nhiều lần từ chối. Đêm hôm đó, họ đến một căn biệt thự xa trung tâm thành phố, nơi Linh bảo là “chốn yên tĩnh để hiểu nhau hơn.”</p>

<p>Bên ánh nến, Minh đắm chìm trong sự cuốn hút ma mị của Linh. Nhưng khi anh chạm vào tay cô, da thịt cô lạnh toát như băng. Đôi mắt đen của cô đột nhiên rực sáng, và giọng nói vang lên: <em>“Ngươi thích cảm giác chiếm hữu người khác, đúng không? Vậy hãy ở lại, mãi mãi.”</em></p>

<p>Minh hoảng sợ rút tay lại, nhưng cánh cửa căn biệt thự đã khóa. Gương mặt Linh biến đổi – làn da nứt nẻ, đôi môi đen sì, và đôi mắt rực lửa. Những hình bóng người con gái mà Minh từng ruồng bỏ hiện ra quanh anh, vây lấy anh bằng tiếng khóc, tiếng cười ghê rợn.</p>

<p>Ngày hôm sau, biệt thự đó được phát hiện là nơi bỏ hoang nhiều năm. Không ai thấy Minh nữa. Nhưng người dân quanh đó kể, mỗi đêm ánh đèn lại lập lòe trong căn nhà cũ, và mùi hương lạ – ngọt ngào nhưng đầy chết chóc – cứ phảng phất trong không khí.</p>

<p><em>Bài học: Dục vọng không được kiểm soát là cánh cửa mở vào địa ngục. Những gì con người tưởng là khoái cảm có thể chính là chiếc bẫy ngọt ngào giam hãm linh hồn họ vĩnh viễn.</em></p>
',
        '2025-04-27 22:15:00.000000');

-- Insert Chapter 4: Lười Biếng (Sloth)
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('8d04039b-4da4-4d89-9300-d2b290ecbe2b',
        4,
        'Lười biếng – Cái giá của sự trì hoãn',
        '3f9a690b-94d7-4c7b-a243-907d0a254a11',
        '<p>Huy là một sinh viên thông minh, có năng khiếu lập trình bẩm sinh và từng đạt nhiều giải thưởng tin học. Ai cũng tin rằng tương lai của cậu sẽ rực rỡ, chỉ chờ Huy hành động. Nhưng chính Huy lại là người không tin vào chính mình – hay đúng hơn, không đủ động lực để bắt đầu bất cứ điều gì.</p>

<p>“Để mai làm cũng được”, “chắc chưa tới deadline đâu”… là những câu quen thuộc trong miệng Huy. Cậu luôn viện lý do: áp lực, mệt mỏi, hay đôi khi chỉ là… buồn ngủ. Mỗi lần có cơ hội đến, Huy đều trì hoãn: một dự án khởi nghiệp bị bỏ lỡ, một lời mời thực tập từ công ty lớn bị quên trong email chưa đọc.</p>

<p>Dần dần, những người bạn từng ngưỡng mộ cậu đã đi xa. Họ có công việc, có đam mê, còn Huy vẫn quanh quẩn trong căn phòng chật chội, sống dựa vào cha mẹ và những giấc mơ chưa thành hình. Cậu viện lý do rằng mình cần “thêm thời gian để chuẩn bị hoàn hảo”, nhưng thật ra, chỉ là đang trốn tránh sự chuyển mình.</p>

<p>Một đêm nọ, Huy thức trắng trước màn hình laptop – không phải để làm việc, mà để tiếp tục chuỗi ngày lướt mạng, xem video vô nghĩa. Đôi mắt cậu cay xè, nhưng tay không thể dừng. Rồi bỗng, màn hình chớp liên tục. Một giọng nói vang lên từ trong máy:</p>

<p><em>“Ngươi đã lãng phí quá nhiều thời gian. Ta là hiện thân của những cơ hội bị giết chết, những hành động không bao giờ thực hiện. Đến lúc ngươi phải trả giá.”</em></p>

<p>Huy sợ hãi rút dây điện ra, nhưng máy vẫn sáng. Từ màn hình, những bàn tay xám xịt vươn ra, kéo Huy vào khoảng tối sâu hun hút. Trước khi biến mất, cậu chỉ kịp thấy vô số gương mặt giống mình, đang ngủ gật trong bóng tối – những linh hồn bị mắc kẹt vĩnh viễn vì lười biếng và trì hoãn.</p>

<p>Sáng hôm sau, căn phòng trống trơn. Người ta tìm thấy chiếc laptop vẫn mở, hiển thị một dòng chữ nhấp nháy: <strong><em>“Đã quá muộn.”</em></strong></p>

<p><em>Bài học: Lười biếng là sát thủ thầm lặng của ước mơ. Không phải vì bạn không có khả năng, mà vì bạn không chịu bắt đầu. Trì hoãn ngày hôm nay là tự tay chôn vùi tương lai của chính mình.</em></p>
',
        '2025-04-27 22:20:00.000000');

-- Insert Chapter 5: Phẫn nộ
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('c573bd87-2057-4323-9b60-3c48c033a327',
        5,
        'Phẫn nộ – Ngọn lửa nuốt chửng chính mình',
        '3f9a690b-94d7-4c7b-a243-907d0a254a11',
        '<p>Nam từng là một người lính cứu hỏa can đảm, nổi tiếng trong khu phố nhỏ vì tinh thần dũng cảm và lòng nhân ái. Nhưng trong một lần cứu hộ lớn, anh đã không thể cứu được vợ và con trai – những người mắc kẹt trong một tòa chung cư bốc cháy dữ dội. Kể từ đó, lòng Nam trở nên hoang tàn như những mảnh tro tàn anh từng bước qua.</p>

<p>Nam không còn tin vào công lý, không còn tin vào lòng người. Anh cho rằng cả thế giới đã quay lưng với mình. Cái chết của vợ con anh không ai chịu trách nhiệm, và tòa nhà đó – do một tập đoàn lớn thi công ẩu – vẫn tiếp tục mọc cao trên xương máu người khác.</p>

<p>Suốt nhiều năm, Nam sống như một bóng ma giữa lòng thành phố. Anh dành thời gian theo dõi những người đứng đầu tập đoàn kia – từng hành vi, từng bước đi – tất cả đều được ghi chép tỉ mỉ trong một cuốn sổ đen. Lòng anh không còn chỗ cho tha thứ, chỉ còn ngọn lửa thù hận cháy âm ỉ không nguôi.</p>

<p>Rồi một đêm mưa, Nam hành động. Anh đột nhập vào trụ sở tập đoàn, chất đầy xăng trong phòng họp nơi các cổ đông đang tổ chức tiệc tùng. Trước khi châm lửa, anh đọc to tên vợ con mình và hét lên: <em>“Công lý không đến, thì tôi sẽ là công lý!”</em></p>

<p>Ngọn lửa bùng lên, thiêu rụi toàn bộ tầng nhà. Nhưng khi lính cứu hỏa đến hiện trường, họ không tìm thấy xác Nam. Chỉ có một bóng người đứng lặng trên tầng thượng, đôi mắt đỏ rực và khói xám cuộn quanh như áo choàng.</p>

<p>Từ sau vụ cháy đó, mỗi lần có đám cháy lớn trong thành phố, lính cứu hỏa lại kể về một bóng người xuất hiện trong lửa, như hướng dẫn họ đến nơi có người mắc kẹt. Nhưng gương mặt người ấy không bao giờ rõ – chỉ có đôi mắt bốc cháy như tro than, và tiếng thì thầm trong gió: <em>“Tôi vẫn đang thiêu đốt… để nhớ họ.”</em></p>

<p><em>Bài học: Phẫn nộ không kiểm soát có thể trở thành ngọn lửa thiêu cháy chính linh hồn ta. Công lý không bao giờ đến từ sự trả thù – mà từ sự dũng cảm đối mặt với đau thương và buông bỏ nó.</em></p>
',
        '2025-04-27 22:25:00.000000');

-- Insert Chapter 6: Dục Vọng (Lust)
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('a95b38c1-cb12-4d42-8502-fd50c37872c1',
        6,
        'Đố kỵ – Khi ánh sáng của người khác khiến bóng tối trong ta lớn dần',
        '3f9a690b-94d7-4c7b-a243-907d0a254a11',
        '<p>Lan là một họa sĩ trẻ, từng học chung trường mỹ thuật với Ngọc – người bạn thân thuở nhỏ. Trong khi Lan vẫn loay hoay với vài bức vẽ bán lẻ trên mạng, thì Ngọc đã trở thành một cái tên nổi bật, được mời triển lãm ở Paris, được các tạp chí danh tiếng săn đón.</p>

<p>Ban đầu, Lan tự dặn lòng rằng mình vui cho bạn. Nhưng mỗi lần thấy bài viết về thành công của Ngọc trên mạng xã hội, trong lòng Lan lại xuất hiện một cơn sóng âm ỉ – vừa ngưỡng mộ, vừa cay đắng. “Tài năng của mình cũng đâu kém?”, “Nếu mình có điều kiện như nó, chắc chắn cũng nổi tiếng”… Những suy nghĩ ấy dần biến thành hận thù không tên.</p>

<p>Lan bắt đầu giả danh người lạ, bình luận công kích dưới các bài đăng của Ngọc. Cô lan truyền tin đồn rằng Ngọc đạo tranh, rằng cô được nổi tiếng là do quen biết chứ không phải tài năng. Mỗi lần Ngọc tổn thương, Lan lại thấy một niềm thỏa mãn lạ kỳ – như thể lấy lại công bằng.</p>

<p>Rồi một đêm, Lan ngồi trước bức tranh lớn nhất đời mình, định gửi đi tham dự một cuộc thi quốc tế. Nhưng khi mở nắp màu, cô thấy tất cả đã hóa đen, như tro tàn. Cây cọ trên tay cô tự gãy đôi. Gương mặt Lan phản chiếu trong kính mờ đi, thay vào đó là vô số bản sao của chính cô – ghen tỵ, méo mó, vô định.</p>

<p>Giữa đêm, Ngọc gọi điện. Giọng cô run rẩy: “Lan, mình biết hết rồi… Mình không trách. Chỉ buồn vì người bạn mình từng yêu quý nhất lại chính là người khiến mình tổn thương nhất.”</p>

<p>Lan không trả lời. Trong lòng cô, niềm đố kỵ giờ đây không còn là ngọn lửa mà đã trở thành tro nguội. Nhưng những gì cô đã đốt – tình bạn, niềm tin, nhân cách – chẳng thể lấy lại.</p>

<p><em>Bài học: Đố kỵ không làm ta tốt hơn, nó chỉ khiến ta tự đốt cháy những điều đẹp đẽ trong mình. Thay vì nhìn ánh sáng của người khác bằng ghen ghét, hãy để nó soi đường cho ta vươn lên.</em></p>
',
        '2025-04-27 22:30:00.000000');

-- Insert Chapter 7: Tự Mãn (Pride)
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('b62c3a76-8e57-40e2-9f98-76db41ac6eb5',
        7,
        ' Kiêu ngạo – Tội lỗi cuối cùng và lớn nhất',
        '3f9a690b-94d7-4c7b-a243-907d0a254a11',
        '
<p>Anh Khải – một giáo sư triết học nổi tiếng, giảng viên hàng đầu của một trường đại học danh giá. Ông từng được ví như “ngọn hải đăng đạo đức” của thế hệ trẻ. Nhưng ẩn sâu sau danh tiếng ấy là một cái tôi khổng lồ – thứ mà ông chưa từng thừa nhận.</p>

<p>Khải tin rằng mình luôn đúng. Ông khinh thường những đồng nghiệp có quan điểm khác, cho rằng sinh viên không thể phản biện. Những ai không tán dương ông đều bị gạt ra khỏi vòng ảnh hưởng. “Tôi là đỉnh cao trí tuệ”, ông từng nói trong một buổi phỏng vấn.</p>

<p>Một ngày nọ, một sinh viên trẻ tên Minh đặt câu hỏi phản biện về triết lý đạo đức mà ông dạy. Khải nổi giận, công khai chê bai Minh trước lớp. Nhưng Minh không im lặng. Cậu gửi bài phản biện lên diễn đàn học thuật, dẫn chứng rõ ràng, ngôn từ sắc sảo. Bài viết lan truyền chóng mặt.</p>

<p>Ban đầu, Khải cười khẩy. “Lũ trẻ thì biết gì?” Nhưng càng ngày, ông càng mất đi sự kính trọng từ đồng nghiệp, sinh viên dần quay lưng. Lòng tự cao không cho phép ông nhận sai. Ông âm thầm tìm đến Minh, định yêu cầu xóa bài viết, nhưng khi nhìn ánh mắt kiên định và trong sáng của cậu sinh viên, Khải cảm thấy lần đầu trong đời… xấu hổ.</p>

<p>Vài tuần sau, Khải tuyên bố rút lui khỏi giảng dạy. Trong buổi họp mặt cuối cùng, ông đứng lặng một hồi, rồi nói: “Tôi đã sống nhiều năm trên đỉnh tự phụ, và giờ tôi biết đó là một ngọn núi trống rỗng. Kiêu ngạo khiến tôi không còn nhìn thấy sự thật.”</p>

<p>Ông quay lại viết sách, không còn là người rao giảng chân lý, mà là kẻ đi tìm nó – khiêm tốn, cẩn trọng, và biết lắng nghe. Cuốn sách cuối cùng ông viết có tên: <strong><em>“Học lại làm người.”</em></strong></p>

<p><em>Bài học: Kiêu ngạo là chiếc mặt nạ đẹp đẽ che giấu sự sợ hãi và yếu đuối bên trong. Chỉ khi buông bỏ nó, ta mới có thể thật sự lớn lên.</em></p>
',
        '2025-04-27 22:35:00.000000');

