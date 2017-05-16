/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     15/05/2017 06.10.11                          */
/*==============================================================*/


drop table if exists ADMIN;

drop table if exists DARURAT;

drop table if exists DOKTERKU;

drop table if exists LOKASI;

drop table if exists OBAT;

drop table if exists PENGGUNA;

drop table if exists QUOTE;

drop table if exists STATUS;

drop table if exists TIPS_KESEHATAN;

/*==============================================================*/
/* Table: ADMIN                                                 */
/*==============================================================*/
create table ADMIN
(
   ID_ADMIN             int not null,
   USERNAMEADMIN        varchar(25),
   PASSWORDADMIN        varchar(25),
   primary key (ID_ADMIN)
);

/*==============================================================*/
/* Table: DARURAT                                               */
/*==============================================================*/
create table DARURAT
(
   ID_DARURAT           int not null,
   ID_LOKASI            int,
   ID_USER              int,
   ID_ADMIN             int,
   NAMA_DARURAT         varchar(80),
   NO_TELEPON           varchar(15),
   ALAMAT               text,
   primary key (ID_DARURAT)
);

/*==============================================================*/
/* Table: DOKTERKU                                              */
/*==============================================================*/
create table DOKTERKU
(
   ID_DOKTER            int not null,
   ID_USER              int,
   ID_ADMIN             int,
   NAMA_DOKTER          varchar(80),
   SPESIALIST           varchar(50),
   ALAMAT_DOKTER        text,
   GAMBAR_DOKTER        varchar(60),
   primary key (ID_DOKTER)
);

/*==============================================================*/
/* Table: LOKASI                                                */
/*==============================================================*/
create table LOKASI
(
   ID_LOKASI            int not null,
   ID_DARURAT           int,
   LATITUDE             float(50),
   LONGITUDE            float(50),
   primary key (ID_LOKASI)
);

/*==============================================================*/
/* Table: OBAT                                                  */
/*==============================================================*/
create table OBAT
(
   ID_OBAT              int not null,
   ID_STATUS            int,
   ID_USER              int,
   ID_ADMIN             int,
   NAMA_OBAT            varchar(40),
   KEGUNAAN             varchar(40),
   GAMBAR_OBAT          varchar(60),
   DOSIS                varchar(30),
   primary key (ID_OBAT)
);

/*==============================================================*/
/* Table: PENGGUNA                                              */
/*==============================================================*/
create table PENGGUNA
(
   ID_USER              int not null,
   ID_ADMIN             int,
   USERNAME             varchar(30),
   PASSWORD             varchar(30),
   primary key (ID_USER)
);

/*==============================================================*/
/* Table: QUOTE                                                 */
/*==============================================================*/
create table QUOTE
(
   ID_QUOTE             int not null,
   ID_USER              int,
   ID_ADMIN             int,
   ISI_QUOTE            varchar(60),
   primary key (ID_QUOTE)
);

/*==============================================================*/
/* Table: STATUS                                                */
/*==============================================================*/
create table STATUS
(
   ID_STATUS            int not null,
   ID_OBAT              int,
   HARI                 date,
   JAM                  time,
   primary key (ID_STATUS)
);

/*==============================================================*/
/* Table: TIPS_KESEHATAN                                        */
/*==============================================================*/
create table TIPS_KESEHATAN
(
   ID_TIPS              int not null,
   ID_USER              int,
   ID_ADMIN             int,
   JUDUL                varchar(30),
   ISI                  varchar(2147483647),
   GAMBAR               varchar(60),
   primary key (ID_TIPS)
);

alter table DARURAT add constraint FK_MEMANGGIL foreign key (ID_USER)
      references PENGGUNA (ID_USER) on delete restrict on update restrict;

alter table DARURAT add constraint FK_MEMBUAT foreign key (ID_ADMIN)
      references ADMIN (ID_ADMIN) on delete restrict on update restrict;

alter table DARURAT add constraint FK_MENUNJUKKAN_TEMPAT2 foreign key (ID_LOKASI)
      references LOKASI (ID_LOKASI) on delete restrict on update restrict;

alter table DOKTERKU add constraint FK_KONSULTASI foreign key (ID_USER)
      references PENGGUNA (ID_USER) on delete restrict on update restrict;

alter table DOKTERKU add constraint FK_MENDATA foreign key (ID_ADMIN)
      references ADMIN (ID_ADMIN) on delete restrict on update restrict;

alter table LOKASI add constraint FK_MENUNJUKKAN_TEMPAT foreign key (ID_DARURAT)
      references DARURAT (ID_DARURAT) on delete restrict on update restrict;

alter table OBAT add constraint FK_MEMINUM foreign key (ID_STATUS)
      references STATUS (ID_STATUS) on delete restrict on update restrict;

alter table OBAT add constraint FK_MENGEDIT foreign key (ID_ADMIN)
      references ADMIN (ID_ADMIN) on delete restrict on update restrict;

alter table OBAT add constraint FK_MENINJAU foreign key (ID_USER)
      references PENGGUNA (ID_USER) on delete restrict on update restrict;

alter table PENGGUNA add constraint FK_MENGATUR foreign key (ID_ADMIN)
      references ADMIN (ID_ADMIN) on delete restrict on update restrict;

alter table QUOTE add constraint FK_MENGUBAH foreign key (ID_ADMIN)
      references ADMIN (ID_ADMIN) on delete restrict on update restrict;

alter table QUOTE add constraint FK_SEE foreign key (ID_USER)
      references PENGGUNA (ID_USER) on delete restrict on update restrict;

alter table STATUS add constraint FK_MEMINUM2 foreign key (ID_OBAT)
      references OBAT (ID_OBAT) on delete restrict on update restrict;

alter table TIPS_KESEHATAN add constraint FK_MELIHAT foreign key (ID_USER)
      references PENGGUNA (ID_USER) on delete restrict on update restrict;

alter table TIPS_KESEHATAN add constraint FK_MENAMBAH foreign key (ID_ADMIN)
      references ADMIN (ID_ADMIN) on delete restrict on update restrict;

