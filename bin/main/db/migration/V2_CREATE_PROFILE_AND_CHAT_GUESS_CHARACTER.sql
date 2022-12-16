CREATE TABLE IF NOT EXISTS TB_CHAT_PROFILE_CHARACTER(
    profile_identifier SERIAL NOT NULL,
    chat_identifier SERIAL NOT NULL,
    character_name CHAR(120) NOT NULL,
    character_created_date TIMESTAMP NOT NULL,
    character_updated_date TIMESTAMP,
    CONSTRAINT fk_profile_character_id FOREIGN KEY(profile_identifier) REFERENCES TB_PROFILE (profile_identifier),
    CONSTRAINT fk_chat_character_id FOREIGN KEY(chat_identifier) REFERENCES TB_CHAT (chat_identifier)
);