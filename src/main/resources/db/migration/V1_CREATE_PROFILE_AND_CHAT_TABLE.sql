CREATE TABLE IF NOT EXISTS TB_PROFILE(
    profile_identifier SERIAL PRIMARY KEY,
    profile_firstname CHAR(60) NOT NULL,
    profile_lastname CHAR(60) NOT NULL,
    profile_photo_url CHAR(255),
    profile_email CHAR(255) UNIQUE NOT NULL,
    profile_keycloak_identifier SERIAL NOT NULL,
    profile_created_date TIMESTAMP NOT NULL,
    profile_updated_date TIMESTAMP
); 

CREATE TABLE TB_PROFILE_FOLLOWER(
    profile_identifier SERIAL NOT NULL,
    follower_identifier SERIAL NOT NULL,
    CONSTRAINT fk_profile_id FOREIGN KEY(profile_identifier) REFERENCES TB_PROFILE (profile_identifier),
    CONSTRAINT fk_follower_id FOREIGN KEY(profile_identifier) REFERENCES TB_PROFILE (profile_identifier),
    CONSTRAINT pk_profile_follower_id PRIMARY KEY (profile_identifier, follower_identifier)
);

CREATE TABLE IF NOT EXISTS TB_CHAT(
    chat_identifier SERIAL PRIMARY KEY,
    chat_name CHAR(60) NOT NULL,
    chat_photo_url CHAR(255),
    chat_created_date TIMESTAMP NOT NULL,
    chat_updated_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS TB_PROFILE_CHAT(
    profile_identifier SERIAL NOT NULL,
    chat_identifier SERIAL NOT NULL,
    CONSTRAINT fk_profile_id FOREIGN KEY(profile_identifier) REFERENCES TB_PROFILE (profile_identifier),
    CONSTRAINT fk_chat_id FOREIGN KEY(chat_identifier) REFERENCES TB_CHAT (chat_identifier),
    CONSTRAINT pk_profile_chat_id PRIMARY KEY (profile_identifier, chat_identifier)
);