INSERT INTO CLUB (id, name, country) VALUES (1, 'CCR Alto do Moinho', 'Portugal');

INSERT INTO TEAM (id, name, category, sport) VALUES (1, 'Senior', '', 'Handball');

INSERT INTO PLAYER (id, full_name, position, shirt_number, federation_number, weight, height) VALUES (1, 'Pedro Miguel Viegas Malvas Silva',          'PD',   '3',    222773, '90',   '185');
INSERT INTO PLAYER (id, full_name, position, shirt_number, federation_number, weight, height) VALUES (2, 'Duarte Jose Ribeiro Reis',                  'C',    '4',    208652, '90',   '185');
INSERT INTO PLAYER (id, full_name, position, shirt_number, federation_number, weight, height) VALUES (3, 'Diogo Lapa Abadia',                         'C',    '7',    183251, '90',   '185');
INSERT INTO PLAYER (id, full_name, position, shirt_number, federation_number, weight, height) VALUES (4, 'Rui Pedro Almeida Gonçalves',               'LE',   '8',    188242, '90',   '185');
INSERT INTO PLAYER (id, full_name, position, shirt_number, federation_number, weight, height) VALUES (5, 'Francisco Barreiros Larcher Santos Cruz',   'C',    '10',   197557, '90',   '185');
INSERT INTO PLAYER (id, full_name, position, shirt_number, federation_number, weight, height) VALUES (6, 'João Henrique Coelho Veloso',               'PE',   '11',   197254, '90',   '185');
INSERT INTO PLAYER (id, full_name, position, shirt_number, federation_number, weight, height) VALUES (7, 'Francisco Felix Felício',                   'LD',   '13',   199902, '90',   '185');
INSERT INTO PLAYER (id, full_name, position, shirt_number, federation_number, weight, height) VALUES (8, 'João Pedro Martins Machado',                'LD',   '15',   195333, '90',   '185');
INSERT INTO PLAYER (id, full_name, position, shirt_number, federation_number, weight, height) VALUES (9, 'Pedro Maria Brassard Fonseca',              'GK',   '16',   239242, '90',   '185');
INSERT INTO PLAYER (id, full_name, position, shirt_number, federation_number, weight, height) VALUES (10, 'Nuno Miguel Paiva Madruga Nunes',          'LD',   '19',   195858, '90',   '185');
INSERT INTO PLAYER (id, full_name, position, shirt_number, federation_number, weight, height) VALUES (11, 'Tiago Filipe Castanheira Gil',             'LE',   '22',   158488, '90',   '185');
INSERT INTO PLAYER (id, full_name, position, shirt_number, federation_number, weight, height) VALUES (12, 'Fernando Jorge Mendes Baptista',           'PV',   '23',   226632, '90',   '185');
INSERT INTO PLAYER (id, full_name, position, shirt_number, federation_number, weight, height) VALUES (13, 'Miguel Caetano Costa Santos',              'GK',   '24',   211113, '90',   '185');
INSERT INTO PLAYER (id, full_name, position, shirt_number, federation_number, weight, height) VALUES (14, 'Ivan Santos Rocha',                        'PV',   '26',   218764, '90',   '185');

INSERT INTO PLAYER_TEAMS (player_id, team_id) VALUES (1, 1);
INSERT INTO PLAYER_TEAMS (player_id, team_id) VALUES (2, 1);
INSERT INTO PLAYER_TEAMS (player_id, team_id) VALUES (3, 1);
INSERT INTO PLAYER_TEAMS (player_id, team_id) VALUES (4, 1);
INSERT INTO PLAYER_TEAMS (player_id, team_id) VALUES (5, 1);
INSERT INTO PLAYER_TEAMS (player_id, team_id) VALUES (6, 1);
INSERT INTO PLAYER_TEAMS (player_id, team_id) VALUES (7, 1);
INSERT INTO PLAYER_TEAMS (player_id, team_id) VALUES (8, 1);
INSERT INTO PLAYER_TEAMS (player_id, team_id) VALUES (9, 1);
INSERT INTO PLAYER_TEAMS (player_id, team_id) VALUES (10, 1);
INSERT INTO PLAYER_TEAMS (player_id, team_id) VALUES (11, 1);
INSERT INTO PLAYER_TEAMS (player_id, team_id) VALUES (12, 1);
INSERT INTO PLAYER_TEAMS (player_id, team_id) VALUES (13, 1);
INSERT INTO PLAYER_TEAMS (player_id, team_id) VALUES (14, 1);

--INSERT INTO TEAM (id, name) VALUES (1, 'CCR Alto do Moinho');
--INSERT INTO TEAM (id, name) VALUES (2, 'GM 1º Dezembro');
--INSERT INTO TEAM (id, name) VALUES (3, 'CA Rangers Telheiras');
--INSERT INTO TEAM (id, name) VALUES (4, 'ADC Benavente');
--INSERT INTO TEAM (id, name) VALUES (5, 'CF Estrela Amadora');
--INSERT INTO TEAM (id, name) VALUES (6, 'CCP Serpa');
--INSERT INTO TEAM (id, name) VALUES (7, 'Naval Setubalense');
--INSERT INTO TEAM (id, name) VALUES (8, 'SL Benfica "B"');
--INSERT INTO TEAM (id, name) VALUES (9, 'CSS Pinhal Frades');
--
--INSERT INTO STAFF (STAFF_ID, STAFF_FULL_NAME, STAFF_ROLE, STAFF_TEAM_ID) VALUES (1, 'Tomás Cruz', 'Treinador Principal', 1);
--INSERT INTO STAFF (STAFF_ID, STAFF_FULL_NAME, STAFF_ROLE, STAFF_TEAM_ID) VALUES (2, 'Sandra Contente', 'Fisioterapeuta', 1);
--INSERT INTO STAFF (STAFF_ID, STAFF_FULL_NAME, STAFF_ROLE, STAFF_TEAM_ID) VALUES (3, 'Horácio Paulo', 'Dirigente', 1);
--
----INSERT INTO PLAYER (id, fullName, shirtNumber, cipa, dominantSide, dateOfBirth, weight, height, team_id) VALUES (1, 'Pedro Miguel Viegas Malvas Silva', '3', 222773, 'Left', '2006-07-21', 12, 12, 1);
----INSERT INTO PLAYER (id, fullName, shirtNumber, cipa, dominantSide, dateOfBirth, weight, height, team_id) VALUES (2, 'Duarte Jose Ribeiro Reis', '4', 208652, 'Right', '2005-05-08', 12, 12, 1);
----INSERT INTO PLAYER (id, fullName, shirtNumber, cipa, dominantSide, dateOfBirth, weight, height, team_id) VALUES (3, 'Diogo Lapa Abadia', '7', 183251, 'Right', '1998-12-19', 12, 12, 1);
----INSERT INTO PLAYER (id, fullName, shirtNumber, cipa, dominantSide, dateOfBirth, weight, height, team_id) VALUES (4, 'Rui Pedro Almeida Gonçalves', '8', 188242, 'Right', '1999-05-08', 12, 12, 1);
----INSERT INTO PLAYER (id, fullName, shirtNumber, cipa, dominantSide, dateOfBirth, weight, height, team_id) VALUES (5, 'Francisco Barreiros Larcher Santos Cruz', '10', 197557, 'Right', '1999-01-20', 12, 12, 1);
----INSERT INTO PLAYER (id, fullName, shirtNumber, cipa, dominantSide, dateOfBirth, weight, height, team_id) VALUES (6, 'João Henrique Coelho Veloso', '11', 197254, 'Right', '1995-09-02', 12, 12, 1);
----INSERT INTO PLAYER (id, fullName, shirtNumber, cipa, dominantSide, dateOfBirth, weight, height, team_id) VALUES (7, 'Francisco Felix Felício', '13', 199902, 'Left', '2000-01-15', 12, 12, 1);
----INSERT INTO PLAYER (id, fullName, shirtNumber, cipa, dominantSide, dateOfBirth, weight, height, team_id) VALUES (8, 'João Pedro Martins Machado', '15', 195333, 'Right', '1997-01-03', 12, 12, 1);
----INSERT INTO PLAYER (id, fullName, shirtNumber, cipa, dominantSide, dateOfBirth, weight, height, team_id) VALUES (9, 'Pedro Maria Brassard Fonseca', '16', 239242, 'Right', '2005-01-27', 12, 12, 1);
----INSERT INTO PLAYER (id, fullName, shirtNumber, cipa, dominantSide, dateOfBirth, weight, height, team_id) VALUES (10, 'Nuno Miguel Paiva Madruga Nunes', '19', 195858, 'Right', '1997-03-11', 90, 185, 1);
----INSERT INTO PLAYER (id, fullName, shirtNumber, cipa, dominantSide, dateOfBirth, weight, height, team_id) VALUES (11, 'Tiago Filipe Castanheira Gil', '22', 158488, 'Right', '1990-08-30', 12, 12, 1);
----INSERT INTO PLAYER (id, fullName, shirtNumber, cipa, dominantSide, dateOfBirth, weight, height, team_id) VALUES (12, 'Fernando Jorge Mendes Baptista', '23', 226632, 'Right', '1994-02-24', 12, 12, 1);
----INSERT INTO PLAYER (id, fullName, shirtNumber, cipa, dominantSide, dateOfBirth, weight, height, team_id) VALUES (13, 'Miguel Caetano Costa Santos', '24', 211113, 'Right', '1994-02-24', 12, 12, 1);
----INSERT INTO PLAYER (id, fullName, shirtNumber, cipa, dominantSide, dateOfBirth, weight, height, team_id) VALUES (14, 'Ivan Santos Rocha', '26', 218764, 'Right', '2000-06-25', 12, 12, 1);
----
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (1, 5);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (1, 3);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (2, 6);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (2, 2);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (2, 3);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (3, 6);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (3, 2);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (3, 3);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (4, 6);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (4, 2);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (4, 3);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (5, 6);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (5, 2);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (5, 3);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (6, 4);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (7, 5);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (7, 3);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (8, 6);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (8, 2);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (8, 3);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (9, 1);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (10, 6);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (10, 2);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (10, 3);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (11, 6);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (11, 2);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (11, 3);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (12, 7);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (13, 1);
----INSERT INTO PLAYER_PER_POSITION (PLA_ID, POS_ID) VALUES (14, 7);
----
--
