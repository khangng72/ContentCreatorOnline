-- Insert the new story
INSERT INTO story
(story_id, release_status, story_title, story_description, user_id, created_time)
VALUES ('a3e41d5d-51f1-4e3a-8d9a-4d0e9e8c7c05',
        true,
        'A Dance Beneath the Starlit Skies',
        'In the kingdoms of Valeria and Eldoria, a war once raged. To forge peace, Prince Adrian of Valeria and Princess Selene of Eldoria were to meet. What began as a duty blossomed into a love neither had expected. Through secret letters, midnight dances, and a bond that defied old wounds, they discovered that sometimes, love can heal even the deepest scars.',
        'f6b24e76-2cd6-4881-86e9-ffadbba23720',
        '2025-04-27 18:25:00.000000');

-- Insert chapters for the love story
-- Chapter 1
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('9de1bfa6-5cf7-4aeb-9f25-1c7738ec22b9',
        1,
        'The First Meeting',
        'a3e41d5d-51f1-4e3a-8d9a-4d0e9e8c7c05',
        '<p>The Great Hall of Valeria shone with a thousand lanterns, their light reflecting off the polished marble. 🌟 Prince Adrian stood by the towering windows, dreading the arrival of the Eldorian delegation. He expected a stiff princess, a political pawn. But when Princess Selene entered — graceful, fierce, and unafraid — the world seemed to stop. 💫</p>
        <p>They were introduced formally, exchanging polite smiles. But in that brief touch of hands, something unspoken passed between them — something neither duty nor politics could erase. ❤️</p>',
        '2025-04-27 18:26:00.000000');

-- Chapter 2
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('e54d6c09-2702-4609-92b7-2fd2df0e715e',
        2,
        'Whispers in the Garden',
        'a3e41d5d-51f1-4e3a-8d9a-4d0e9e8c7c05',
        '<p>Under the veil of night, away from the eyes of their courts, Adrian and Selene met in the palace gardens. 🌿🌹 They spoke of dreams, of regrets, of the weight of crowns. Each word drew them closer, weaving a delicate thread of trust between two hearts shaped by the burdens of royalty.</p>
        <p>"I never wanted this war," Selene whispered, her voice breaking. Adrian brushed a tear from her cheek, vowing silently to protect her — and their fragile hope for peace — at any cost. 🌙</p>',
        '2025-04-27 18:27:00.000000');

-- Chapter 3
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('e7f07c56-ff35-4efc-929b-0fef4977ab2b',
        3,
        'A Dance Beneath the Stars',
        'a3e41d5d-51f1-4e3a-8d9a-4d0e9e8c7c05',
        '<p>On the eve of the Peace Festival, Adrian led Selene away from the crowded ballroom to a quiet terrace. There, under a sky dusted with stars, he extended his hand. 💫</p>
        <p>Without music, they danced — slow, clumsy, laughing. It wasn''t perfect, but it was real. As the stars bore witness, Adrian whispered against her hair, "Selene, not even the weight of two kingdoms could keep me from loving you."</p>
                                                                                                                                                                               <p>And for the first time in many generations, Valeria and Eldoria found peace — not from treaties signed in ink, but from love written in the hearts of a prince and princess. 💖👑</p>',
        '2025-04-27 18:28:00.000000');

-- Insert the bonus Epilogue chapter
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('b6f8b2d0-1b64-4d63-9254-bd66c7df8c5a',
        4,
        'Epilogue: A Kingdom Reborn',
        'a3e41d5d-51f1-4e3a-8d9a-4d0e9e8c7c05',
        '<p>Years had passed since the night Adrian and Selene danced beneath the stars. 👑🌟 As King and Queen, they ruled over a united realm now called Valdoria, a land where old grudges had been buried and hope flourished like never before. 🌿✨</p>
        <p>Their reign wasn’t without trials. Rebels who clung to the past tried to stir conflict, doubting a peace built on love. When a harsh drought struck the southern provinces, many questioned whether young love could truly weather the storms of leadership. ⛈️</p>
        <p>But side by side, Adrian and Selene stood firm. They opened the palace gardens to the hungry, forged new alliances with neighboring lands, and led by example — showing kindness, strength, and resilience. 🤝</p>
        <p>One night, after a long day of council meetings and relief efforts, Adrian found Selene once more on the palace terrace. The stars still watched overhead. Taking her hands in his, he smiled and said, "Whatever comes, we face it together."</p>
        <p>Selene laughed, her eyes shining. "Always, my love."</p>
        <p>And so, beneath the same sky where their journey began, their love — and their kingdom — flourished for generations to come. 🌌❤️</p>',
        '2025-04-27 18:32:00.000000');

-- Insert the story
INSERT INTO story
(story_id, release_status, story_title, story_description, user_id, created_time)
VALUES ('f8d3a2e7-0b5e-4cf7-9c9e-4d6f6f35e0aa',
        true,
        'Child of Thunder: Rise of the Guardian',
        'Sixteen-year-old Leo Carter was just an ordinary high school student — until a bolt of lightning during a fierce storm changed everything. Gifted with the power of Zeus, the king of the gods, Leo finds himself thrust into a destiny far greater than anything he ever imagined. Armed with newfound abilities to control lightning and storms, he vows to protect the world from ancient evils reawakening to sow chaos. But with great power comes great enemies — and Leo must prove that even a teenager can become a true guardian of Earth.',
        'f6b24e76-2cd6-4881-86e9-ffadbba23720',
        '2025-04-27 19:02:00.000000');

-- Insert Chapter 1
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('b2c3d4f5-1234-4fed-89ab-987654321001',
        1,
        'The Lightning Strike',
        'f8d3a2e7-0b5e-4cf7-9c9e-4d6f6f35e0aa',
        '<p>It was supposed to be a normal soccer practice. Gray clouds rolled over the town, heavy with rain. As Leo sprinted across the field, a deafening crack split the sky. ⚡ The bolt struck the ground meters away, knocking him off his feet. Blinded by the light, he thought he heard a voice — deep, ancient, powerful — whispering, "Chosen."</p>
        <p>When Leo opened his eyes, he wasn’t hurt. Instead, a strange energy crackled beneath his skin. He could feel it in his veins: power — raw, electric, alive. ⚡🌩️</p>',
        '2025-04-27 19:03:00.000000');

-- Insert Chapter 2
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('c3d4e5f6-2345-5fde-89bc-876543210012',
        2,
        'The Awakening',
        'f8d3a2e7-0b5e-4cf7-9c9e-4d6f6f35e0aa',
        '<p>In the days that followed, strange things happened. Streetlights flickered when Leo walked past. His emotions stirred small thunderstorms. 🌧️ His best friend Mia was the first to notice. "Dude, are you… like, Thor now?" she joked. 🤣</p>
        <p>But this wasn’t mythology — it was real. An ancient artifact, the Aegis Amulet, appeared on his doorstep, along with a letter signed only "Hermes." It spoke of a prophecy: "When the world stands on the brink of ruin, a child of thunder shall rise."</p>',
        '2025-04-27 19:04:00.000000');

-- Insert Chapter 3
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('a1b2c3d4-e5f6-7890-1234-567890abcdef',
        3,
        'Battle of the Forgotten',
        'f8d3a2e7-0b5e-4cf7-9c9e-4d6f6f35e0aa',
        '<p>Darkness descended on the city. Creatures from old nightmares — harpies, shades, and giants — crept into the streets, drawn by the return of divine power. 🧟🌑</p>
        <p>Leo, armed with the amulet and his powers, faced them head-on. Every strike of his fist was a burst of thunder. Every shout was a roaring storm. When he finally confronted the leader, a fallen demigod named Kharon, the ground itself trembled under their clash. ⚔️</p>
        <p>In the end, it wasn’t just his power that saved the world. It was his heart — his belief that he wasn’t just Zeus’s heir, but humanity’s defender. ❤️⚡</p>',
        '2025-04-27 19:05:00.000000');

-- Insert the story
INSERT INTO story
(story_id, release_status, story_title, story_description, user_id, created_time)
VALUES ('e3a5c7b8-1c3d-4f78-9421-8f4e1234abcd',
        true,
        'Web of Destiny',
        'Jake Miller was just another teenager trying to survive high school — until a field trip to a science lab changed his life forever. Bitten by a radioactive spider, Jake discovers he has been gifted with extraordinary powers: the strength to lift cars, the agility to dodge bullets, and the ability to cling to walls. As danger rises in his city, Jake must embrace his new identity and learn that with great power comes great responsibility.',
        'f6b24e76-2cd6-4881-86e9-ffadbba23720',
        '2025-04-27 19:10:00.000000');

-- Insert Chapter 1
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('a1b2c3d4-5678-4abc-8910-1234567890ab',
        1,
        'The Bite',
        'e3a5c7b8-1c3d-4f78-9421-8f4e1234abcd',
        '<p>The day started like any other. Jake wandered through the shiny halls of Genetek Laboratories, half-listening to the guide’s lecture. As he drifted to the back of the group, something bright caught his eye — a strange, glowing spider, spinning an iridescent web. 🕷️</p>
        <p>Before he could react, the spider dropped onto his hand and bit down hard. Jake yelped, shaking it off. Nobody noticed. Nobody saw the moment that would change his life forever. 🕸️⚡</p>',
        '2025-04-27 19:11:00.000000');

-- Insert Chapter 2
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('b2c3d4e5-6789-5bcd-8911-2345678901bc',
        2,
        'New Powers, New Problems',
        'e3a5c7b8-1c3d-4f78-9421-8f4e1234abcd',
        '<p>At first, Jake thought he was just sick. Feverish. Dizzy. But the next morning, he woke up stuck to the ceiling of his bedroom. 😵‍💫</p>
        <p>In the days that followed, he discovered more: unnatural strength, the ability to leap rooftops, a sixth sense warning him of danger. Jake was thrilled — until a run-in with a mugger forced him to make a choice: use these powers selfishly or become something greater. 🏙️🕷️</p>',
        '2025-04-27 19:12:00.000000');

-- Insert Chapter 3
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('c3d4e5f6-7890-6cde-8912-3456789012cd',
        3,
        'Web-Slinger of Midtown',
        'e3a5c7b8-1c3d-4f78-9421-8f4e1234abcd',
        '<p>Jake fashioned a suit, crude at first, and began patrolling the streets. Crime rates started dropping. People whispered about the "Spider Kid" swinging through the city skyline. 🕸️🏙️</p>
        <p>But as his legend grew, so did his enemies. An underground scientist, Dr. Vortex, wanted to harness Jake’s DNA to create an army of spider-enhanced soldiers. 🧪⚡</p>
        <p>In an epic battle across skyscrapers and stormy skies, Jake realized that true strength wasn’t in his powers, but in his courage to stand up for what was right — no matter the cost. 🕷️❤️</p>',
        '2025-04-27 19:13:00.000000');

-- Insert Chapter 4
INSERT INTO chapter (chapter_id, chapter_number, chapter_title, story_id, chapter_content, created_time)
VALUES ('f0e9d8c7-b6a5-4321-fedc-ba9876543210',
        4,
        'Rise of the Web Guardian',
        'e3a5c7b8-1c3d-4f78-9421-8f4e1234abcd',
        '<p>After the fierce battle with Dr. Vortex, Jake realized the city needed more than a masked vigilante — it needed a symbol of hope. 🕸️🌟</p>
        <p>He upgraded his suit, weaving in technology and design improvements. The red and black emblem stitched onto his chest shone proudly: a spider, standing for resilience and protection. 🕷️🛡️</p>
        <p>Calling himself the <strong>Web Guardian</strong>, Jake vowed to defend Midtown and its people. His first test came quickly — a new threat emerged: The Warden, a ruthless tech-genius aiming to enslave the city’s AI systems. 🤖⚡</p>
        <p>In a dazzling showdown atop the city’s tallest tower, Jake fought with everything he had. He webbed up The Warden’s machines, saved hundreds of lives, and proved to himself that he wasn’t just some kid with powers — he was a true hero. 🙌🏽🕷️</p>
        <p>And so began the legend of the Web Guardian, the teenager who chose responsibility, courage, and love for his city over fear. His web wasn’t just spun across buildings — it was spun across the hearts of the people he protected. 🕸️❤️</p>',
        '2025-04-27 19:15:00.000000');




