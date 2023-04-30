INSERT INTO word (id, text, transcription, type)
VALUES (DEFAULT, 'lkmlm', 'mlml', 'VERB'::word_type);
INSERT INTO photo_resources (name, author_id, type, path)
VALUES ('hoho', 1, 'PHOTO'::resources_type, '/ddmd/ddmd');
INSERT INTO photo_card (create_date, repetition_date, catalog_id, word_id, type, photo_resource_id)
VALUES ('2023-04-30 16:59:08.686000 +00:00', '2023-04-30 16:59:11.497000 +00:00', 1, 1, 'PHOTO'::resources_type, 1);