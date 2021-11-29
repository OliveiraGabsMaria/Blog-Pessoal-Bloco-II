CREATE TABLE `tb_tema` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`Romance` varchar(255) NOT NULL AUTO_INCREMENT,
	`Terror` varchar(255) NOT NULL AUTO_INCREMENT,
	`Suspense Policial` varchar(255) NOT NULL AUTO_INCREMENT,
	`Autoajuda` varchar(255) NOT NULL AUTO_INCREMENT,
	`Histórias em Quadrinhos` varchar(255) NOT NULL AUTO_INCREMENT,
	`Literatura Erótica` varchar(255) NOT NULL AUTO_INCREMENT,
	`Cientificos` varchar(255) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_postagens` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`id_usuarios` bigint NOT NULL,
	`id_tema` bigint NOT NULL,
	`Titulo` varchar(255) NOT NULL AUTO_INCREMENT,
	`Nota` int(10) NOT NULL AUTO_INCREMENT,
	`Texto` varchar(5000) NOT NULL AUTO_INCREMENT,
	`Foto` varchar(300) NOT NULL AUTO_INCREMENT,
	`Quote` varchar(1000) NOT NULL AUTO_INCREMENT,
	`Media de Preço` DECIMAL(10,2) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_usuarios` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`Usuário` varchar(300) NOT NULL AUTO_INCREMENT,
	`Senha` varchar(300) NOT NULL AUTO_INCREMENT,
	`Descrição de Perfil` varchar(500) NOT NULL AUTO_INCREMENT,
	`Idade` int(10) NOT NULL AUTO_INCREMENT,
	`Foto` varchar(100) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
);

ALTER TABLE `tb_postagens` ADD CONSTRAINT `tb_postagens_fk0` FOREIGN KEY (`id_usuarios`) REFERENCES `tb_usuarios`(`id`);

ALTER TABLE `tb_postagens` ADD CONSTRAINT `tb_postagens_fk1` FOREIGN KEY (`id_tema`) REFERENCES `tb_tema`(`id`);




