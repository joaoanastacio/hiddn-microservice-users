CREATE TABLE TB_PROFILE(
    profile_identifier SERIAL PRIMARY KEY,
--    profile_username CHAR(25) UNIQUE NOT NULL, Adicionar o username fixo para conta e um variavel para cada conversa
    profile_email CHAR(255) UNIQUE NOT NULL,
--    profile_phone CHAR(20) UNIQUE NOT NULL, Remover
    profile_password CHAR(50) NOT NULL,
    profile_name CHAR(120) NOT NULL,
--    profile_age INT NOT NULL, Remover
--    profile_biography CHAR(240) NOT NULL, Nao obrigatorio
    profile_photo_url CHAR(255),
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

CREATE TABLE TB_CHAT(
    chat_identifier SERIAL PRIMARY KEY,
    chat_name CHAR(60) NOT NULL,
    chat_photo_url CHAR(255),
    chat_created_date TIMESTAMP NOT NULL,
    chat_deleted_date TIMESTAMP
);

CREATE TABLE TB_PROFILE_CHAT(
    profile_identifier SERIAL NOT NULL,
    chat_identifier SERIAL NOT NULL,
    CONSTRAINT fk_profile_chat_id FOREIGN KEY(profile_identifier) REFERENCES TB_PROFILE (profile_identifier),
    CONSTRAINT fk_chat_chat_id FOREIGN KEY(chat_identifier) REFERENCES TB_CHAT (chat_identifier),
    CONSTRAINT pk_profile_chat_id PRIMARY KEY (profile_identifier, chat_identifier)
);