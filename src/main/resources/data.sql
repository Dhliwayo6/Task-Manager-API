-- CREATE DATABASE taskmanager;

use taskmanager;

-- -- select * from tasks;

-- ALTER TABLE task
-- DROP FOREIGN KEY task_ibfk_1;
-- DROP TABLE task;

-- CREATE TABLE app_users (
-- 	id INT AUTO_INCREMENT PRIMARY KEY,
--     username VARCHAR(250) UNIQUE NOT NULL
-- );

-- CREATE TABLE task (
-- 	id INT AUTO_INCREMENT PRIMARY KEY,
--     task VARCHAR(250) UNIQUE NOT NULL,
--     date_created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
--     comments VARCHAR(255),
--     user_id INT,
--     FOREIGN KEY(user_id) REFERENCES app_users(id)
-- );

-- ALTER TABLE task
-- DROP INDEX task
-- ;

-- SHOW INDEX FROM `task`;



-- INSERT INTO app_users (username) VALUES
--   ('jc'),
--   ('sean'),
--   ('alex'),
--   ('riyaaz'),
--   ('ona');

-- INSERT INTO task (task, comments, user_id) VALUES
--   ('Review pull requests', 'Check PRs in repo “backend-api”', 1),
--   ('Write unit tests', NULL, 2),
--   ('Design landing page', 'Wireframes available in Figma', 3),
--   ('Database backup', 'Full backup every Sunday',  1),
--   ('Update user docs', 'Add section on authentication',  4),
--   ('Fix login bug', 'Error when password contains “@”', 5),
--   ('Plan sprint meeting', 'Invite dev & QA teams', 2),
--   ('Optimize image loading', 'Implement lazy-loading', 3),
--   ('Refactor payment module', 'Break into microservices', 1),
--   ('Cleanup old sessions', NULL, 5);

-- select * from app_users;

-- DELETING ON CASCADE

-- 1. Drop the old FK
-- ALTER TABLE task
--   DROP FOREIGN KEY task_ibfk_1;

-- -- 2. Add it back with ON DELETE CASCADE
-- ALTER TABLE task
--   ADD CONSTRAINT task_ibfk_1
--     FOREIGN KEY (user_id)
--     REFERENCES app_users(id)
--     ON DELETE CASCADE;
