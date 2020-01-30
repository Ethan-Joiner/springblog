DROP DATABASE blog_db;

USE blog_db;

INSERT INTO users( username, email, password)
VALUES ( 'User1', 'test@email.com', 'password');

INSERT INTO post_details(history_of_post, is_awesome, topic_description)
VALUES
('History 1', false, 'First details'),
('History 2', true, 'Second details'),
('History 3', false, 'Third details'),
('History 4', true, 'Fourth details');

INSERT INTO posts (title, body, post_details_id)
VALUES
( 'Cats', 'This  is  the body for Cats',1),
( 'Test2', 'This  is  the body for Test2',2),
( 'Test3', 'This  is  the body for Test3',3),
( 'Test4', 'This  is  the body for Test4',4),
( 'Test5', 'This  is  the body for Test5',3),
( 'Test6', 'This  is  the body for Test6',2),
( 'Test7', 'This  is  the body for Test7',4),
( 'Test8', 'This  is  the body for Test8',1),
( 'Test9', 'This  is  the body for Test9',1);

INSERT INTO post_image(image_title, url, post_id)
VALUES
('CatPic1', 'https://media.giphy.com/media/VbnUQpnihPSIgIXuZv/giphy.gif', 1),
('CatPic1', 'https://www.pexels.com/photo/adorable-animal-blur-cat-617278/', 1),
('CatPic1', 'https://www.pexels.com/photo/cat-whiskers-kitty-tabby-20787/', 1);


