DROP DATABASE blog_db;

USE blog_db;

INSERT INTO users(id, username, email, password)
VALUES (1, 'User1', 'test@email.com', 'password');

INSERT INTO posts (title, body, user_id)
VALUES
( 'Test1', 'This  is  the body for Test1', 1),
( 'Test2', 'This  is  the body for Test2', 1),
( 'Test3', 'This  is  the body for Test3', 1),
( 'Test4', 'This  is  the body for Test4', 1),
( 'Test5', 'This  is  the body for Test5', 1),
( 'Test6', 'This  is  the body for Test6', 1),
( 'Test7', 'This  is  the body for Test7', 1),
( 'Test8', 'This  is  the body for Test8', 1),
( 'Test9', 'This  is  the body for Test9', 1);