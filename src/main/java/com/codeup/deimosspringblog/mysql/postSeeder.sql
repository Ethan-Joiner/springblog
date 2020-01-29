DROP DATABASE blog_db;

USE blog_db;

INSERT INTO users( username, email, password)
VALUES
('User1', 'test@email.com', 'password'),
('User2', 'test2@email.com', 'password'),
('User3', 'test3@email.com', 'password');


INSERT INTO posts (title, body, user_id)
VALUES
( 'Test1', 'This  is  the body for Test1', 1),
( 'Test2', 'This  is  the body for Test2', 2),
( 'Test3', 'This  is  the body for Test3', 3),
( 'Test4', 'This  is  the body for Test4', 3),
( 'Test5', 'This  is  the body for Test5', 2),
( 'Test6', 'This  is  the body for Test6', 2),
( 'Test7', 'This  is  the body for Test7', 1),
( 'Test8', 'This  is  the body for Test8', 3),
( 'Test9', 'This  is  the body for Test9', 1);