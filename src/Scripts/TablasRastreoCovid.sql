/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  angep
 * Created: 15-dic-2020
 */

CREATE TABLE People(
    ID int PRIMARY KEY,
    FIRSTNAME varchar(50) NOT NULL,
        LASTNAME varchar(50) NOT NULL);


CREATE TABLE Friends(
    ID1 int,
    ID2 int,
        PRIMARY KEY(ID1, ID2),
    FOREIGN KEY (ID1) REFERENCES People(ID),
    FOREIGN KEY (ID2) REFERENCES People(ID));