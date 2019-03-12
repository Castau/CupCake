USE cupcake;
INSERT INTO `cupcake`.`Cupcake_bottom` (`id_bottom`, `bottom_name`, `bottom_price`) VALUES ('1', 'Chocolate', '5.00');
INSERT INTO `cupcake`.`Cupcake_bottom` (`id_bottom`, `bottom_name`, `bottom_price`) VALUES ('2', 'Vanilla', '5.00');
INSERT INTO `cupcake`.`Cupcake_bottom` (`id_bottom`, `bottom_name`, `bottom_price`) VALUES ('3', 'Nutmeg', '5.00');
INSERT INTO `cupcake`.`Cupcake_bottom` (`id_bottom`, `bottom_name`, `bottom_price`) VALUES ('4', 'Pistacio', '6.00');
INSERT INTO `cupcake`.`Cupcake_bottom` (`id_bottom`, `bottom_name`, `bottom_price`) VALUES ('5', 'Almond', '7.00');

INSERT INTO `cupcake`.`Cupcake_top` (`id_top`, `top_name`, `top_price`) VALUES ('1', 'Chocolate', '5.00');
INSERT INTO `cupcake`.`Cupcake_top` (`id_top`, `top_name`, `top_price`) VALUES ('2', 'Blueberry', '5.00');
INSERT INTO `cupcake`.`Cupcake_top` (`id_top`, `top_name`, `top_price`) VALUES ('3', 'Raspberry', '5.00');
INSERT INTO `cupcake`.`Cupcake_top` (`id_top`, `top_name`, `top_price`) VALUES ('4', 'Crispy', '6.00');
INSERT INTO `cupcake`.`Cupcake_top` (`id_top`, `top_name`, `top_price`) VALUES ('5', 'Strawberry', '6.00');
INSERT INTO `cupcake`.`Cupcake_top` (`id_top`, `top_name`, `top_price`) VALUES ('6', 'Rum/Raisin', '7.00');
INSERT INTO `cupcake`.`Cupcake_top` (`id_top`, `top_name`, `top_price`) VALUES ('7', 'Orange', '8.00');
INSERT INTO `cupcake`.`Cupcake_top` (`id_top`, `top_name`, `top_price`) VALUES ('8', 'Lemon', '8.00');
INSERT INTO `cupcake`.`Cupcake_top` (`id_top`, `top_name`, `top_price`) VALUES ('9', 'Blue cheese', '9.00');



USE cupcake;
INSERT INTO cupcake.User
(id_user, username, password, balance, email)
VALUE
(100, 'Dimwit', 'D1234', 0.0, 'dimwit@dmail.com');

INSERT INTO cupcake.User
(username, password, balance, email)
VALUES
('Mark Money', 'M1234', 0.0, 'macmoneyboi@dmail.com'),
('Hex', 'H1234', 100.0, 'thehex@dmail.com'),
('Lisa', 'L1234', 0.0, 'lizza@dmail.com');

INSERT INTO cupcake.User (username, password, balance, email, role) VALUES
('admin', '1234', 1000.10, 'admin@cupcake.me', 'admin');

INSERT INTO `cupcake`.`Invoice` (`id_invoice`, `id_user`, `totalprice`) VALUES ('1', '100', '10');
INSERT INTO `cupcake`.`Invoice_Details` (`id_invoice_details`, `id_invoice`, `id_top`, `id_bottom`, `quantity`, `price`) VALUES ('1', '1', '2', '1', '1', '10');