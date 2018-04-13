CREATE TABLE "user"
(
  id       BIGSERIAL    PRIMARY KEY,
  username VARCHAR      NOT NULL,
  password VARCHAR      NOT NULL
);
CREATE UNIQUE INDEX user_unique_username_idx ON "user" (username);

CREATE TABLE task
(
  id        BIGSERIAL   PRIMARY KEY,
  user_id   BIGINT      NOT NULL,
  name      VARCHAR     NOT NULL,
  FOREIGN KEY (user_id) REFERENCES "user" (id) ON DELETE CASCADE
);

CREATE TABLE link
(
  id        BIGSERIAL     PRIMARY KEY,
  task_id   BIGINT        NOT NULL,
  value     VARCHAR(1000) NOT NULL,
  title     VARCHAR(1000),
  done      BOOLEAN       NOT NULL DEFAULT FALSE,
  FOREIGN KEY (task_id) REFERENCES task (id) ON DELETE CASCADE
);

