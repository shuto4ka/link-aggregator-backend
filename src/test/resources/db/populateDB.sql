DELETE FROM link;
DELETE FROM task;
DELETE FROM "user";
TRUNCATE TABLE link RESTART IDENTITY CASCADE;
TRUNCATE TABLE task RESTART IDENTITY CASCADE;
TRUNCATE TABLE "user" RESTART IDENTITY CASCADE;

INSERT INTO "user" (username, password) VALUES
  ('user1', '$2a$10$3tMf9I/1FlWNNWexNrmORuYOUrr/5Ir.cZtqojYbczmxltAttq4mG'),
  ('user2', '$2a$10$3tMf9I/1FlWNNWexNrmORuYOUrr/5Ir.cZtqojYbczmxltAttq4mG');

INSERT INTO task (user_id, name) VALUES
  ('1', 'task 1'),
  ('1', 'task 2'),
  ('2', 'task 3');

INSERT INTO link (task_id, value, title, done) VALUES
  (1, 'https://1', 'link 1', FALSE ),
  (1, 'https://2', 'link 2', FALSE ),
  (1, 'https://3', 'link 3', TRUE),
  (2, 'https://4', 'link 4', FALSE ),
  (2, 'https://5', 'link 5', TRUE),
  (3, 'https://6', 'link 6', FALSE );