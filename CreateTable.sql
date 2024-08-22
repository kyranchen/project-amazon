create table master.items(
	id INT primary key, 
	item varchar(30)
)

CREATE TABLE master.user_records (
	id INT NOT NULL,
	name VARCHAR(30) NULL,
	weight FLOAT NULL,
	reps INT NULL,
	body_part VARCHAR(100) NULL,
	`date` DATE NULL
)

create table master.practices (
	id INT not null primary key auto_increment, 
	name varchar(50), 
	body_part varchar(30)
)

insert into master.practices (name, body_part) values ("bench press", "chest")
insert into master.practices (name, body_part) values ("leg press", "leg")
insert into master.practices (name, body_part) values ("shoulder press", "shoulder")
insert into master.practices (name, body_part) values ("lat row", "back")
insert into master.practices (name, body_part) values ("bicep curl", "arm")