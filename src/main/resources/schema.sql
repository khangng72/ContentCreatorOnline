CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table creation(
    creationId UUID default uuid_generate_v4(),
    creationName varchar (50) not null,
    releaseDate Date,
    releaseStatus boolean,
    saleOnly boolean,
    salePrice number,
    numberOfLikes bigint,
    numberOfDislikes bigint,
    coverImageURI varchar (250),
    description varchar (1000),
    primary key (creationId)
);

create table MAKE (
    orderId UUID default uuid_generate_v4(),
    readerId bigint not null,
    primary key(orderId)
);

create table ADDRESS(
    userId UUID default uuid_generate_v4(),
    country varchar (250),
    city varchar(100),
    street varchar(100),
    state varchar
);

create table ORDER(
    orderId UUID default uuid_generate_v4(),
    status varchar (250),
    totalPrice real,
    paidDay date,
    paymentName varchar (100),
    primary key(orderId)
);

create table HAS_CREATION(
    orderId UUID default uuid_generate_v4(),
    creationId default uuid_generate_v4
);

create table IS_USED(
    paymentId UUID default uuid_generate_v4(),
    userId UUID uuid_generate_v4(),
    accountNumber varchar (50)
);

create table PAYMENT(
    paymentId UUID default uuid_generate_v4(),
    paymentName varchar (100),
    primary key (paymentId)
);

create table TAGS(
    creationId UUID default uuid_generate_v4(),
    tag varchar (50)
);

create table READER(
    readerId UUID default uuid_generate_v4(),
    readingTime date,
    isShowInfo varchar (100),
    primary key (readerId)
);

create table JOIN(
    readerId UUID default uuid_generate_v4(),
    creatorId UUID default uuid_generate_v4(),
    tierNumber bigint,
    joinDate date
);

create table  CREATOR(
    creatorId UUID default uuid_generate_v4(),
    numberOfContents bigint,
    numberOfFollowers bigint,
    primary key (creatorId)
);

create table CCO_USER(
    userId UUID  default uuid_generate_v4(),
    firstName varchar (100),
    lastName varchar(100),
    gender varchar(10),
    password varchar(250),
    bDate date,
    nationality varchar(50),
    email varchar(100),
    isAdmin boolean,
    address varchar(250),
    primary key (userId)
);

create table COMMENT(
    commentId UUID default uuid_generate_v4(),
    commentDate date,
    content varchar(250),
    numberOfLikes bigint,
    numberOfDislikes bigint,
    isPinned boolean,
    userId UUID,
    creationId UUID,
    primary key (commentId)
);

create table REPLY(
    commentId UUID,
    replyDate date,
    parentCommentId UUID
);

create table CHAPTER(
    chapterNumber int,
    creationId UUID,
    chapterName varchar (250),
    chapterDescription varchar (4000),
    chapterImageURI varchar (250),
    primary key (chapterNumber, creationId)
);

create table PARAGRAPH (
    paragraphNumber int,
    chapterNumber int,
    creationId UUID,
    paragraphContent varchar (250),
    paragraphImageURI varchar (250),
    primary key (paragraphNumber, chapterNumber, creationId)
);

create table CONTAINS(
    readListId UUID,
    creationId UUID
);

create table READ_LIST(
    readListId UUID default uuid_generate_v4(),
    readListName varchar (250),
    description varchar (1000),
    creationName varchar (250),
    saleOnly boolean,
    salePrice number,
    numberOfLikes bigint,
    numberOdDislikes bigint,
    coverImageURI varchar (250),
    description varchar (250)
);

create table INTERESTED_IN(
    readerId UUID,
    genreId UUID
);

create table JOIN_TIER(
    tierNumber bigint,
    creatorId UUID,
    price number,
    isCharged boolean
);

create table IS_AVAILABLE_IN(
    tierNumber bigint,
    creatorId UUID,
    creationId UUID,
    discountForSaleCreation number
);

create table COMPOSE(
    creationId UUID,
    creatorId UUID
);

create table BELONGS(
    genreId UUID,
    creationId UUID,
);

create table GENRE(
    genreId UUID default uuid_generate_v4() primary key,
    genreName varchar(250)
);

create table HAS_GENRE(
    genreId UUID,
    readListId UUID
);