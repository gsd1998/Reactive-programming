Drop table if exists Product;

create TABLE Product (
	id int AUTO_INCREMENT,
    name varchar(255),
    description varchar(255),
    primary key (id)
);