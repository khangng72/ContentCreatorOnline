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

