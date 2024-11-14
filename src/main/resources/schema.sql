 CREATE EXTENSION IF NOT EXISTS "uuid-poss";

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
      childCommentId UUID,
      creationId UUID,
      primary key (commentId)

  );

 create table READ_LIST(
     readListId UUID default uuid_generate_v4(),
     readListName varchar (250),
     description varchar (1000),
     upVote bigint,
     quantity bigint,
     userId UUID
--     creationName varchar (250),
--     saleOnly boolean,
--     salePrice number,
--     numberOfLikes bigint,
--     numberOdDislikes bigint,
--     coverImageURI varchar (250),
--     description varchar (250)
 );

create table creation(
    creationId default uuid_generate_v4(),
    creationName varchar (50) not null,
    releaseDate Date,
    releaseStatus boolean,
    saleOnly boolean,
    salePrice number,
    numberOfLikes bigint,
    numberOfDislikes bigint,
    coverImageURI varchar (250),
    description varchar (1000),
    tags varchar (1000),
    creatorId UUID,
    primary key (creationId)
);

 create table CHAPTER(
     chapterNumber int,
     chapterName varchar (250),
     chapterDescription varchar (4000),
     chapterImageURI varchar (250),

     creationId UUID,
     primary key (chapterNumber)
 );

 create table PARAGRAPH (
     paragraphNumber int,
     paragraphContent varchar (250),
     paragraphImageURI varchar (250),

     chapterNumber int,
     primary key (paragraphNumber)
 );

 create table PAYMENT(
     paymentId UUID default uuid_generate_v4(),
     paymentName varchar (100),
     primary key (paymentId)
 );

 create table ORDER(
     orderId UUID default uuid_generate_v4(),
     status varchar (250),
     totalPrice real,
     paidDay date,
     paymentName varchar (100),
     readerId  UUID,
     primary key(orderId)
 );

 create table READER(
     readingTime date,
     isShowInfo varchar (100),
     nickName   varchar (100)
 );

 create table  CREATOR(
    penName varchar (100),
     numberOfContents bigint,
     numberOfFollowers bigint,
 );

 create table GENRE(
     genreId UUID default uuid_generate_v4() primary key,
     genreName varchar(250),
     primary key(genreId)
 );

 create table JOIN_TIER(
     tierNumber bigint,
     tierTitle  varchar(1000),
     tierContent varchar(10000),
     tierImageURI   varchar(250),
     price number,
     isCharged boolean,
     status boolean,
     creatorId UUID,
     primary key(tierNumber)
 );

create table TRANSACTION{
    id UUID default uuid_generate_v4(),
    paymentName varchar(250),
    joinDate Date,
    price number,
    tierNumber int,
    readerId UUID,
    primary key(id)
}

 create table CONTAINS(
     id UUID default uuid_generate_v4(),
     readListId UUID,
     creationId UUID,
     primary key(id)
 );

  create table IS_USED(
      id UUID default uuid_generate_v4(),
      paymentId UUID,
      userId UUID,
      accountNumber varchar (50),
      primary key(id)
  );

 create table HAS_CREATION(
     id UUID default uuid_generate_v4(),

     orderId UUID,
     creationId UUID,
     price DOUBLE,
     primary key(id)
 );

 create table HAS_GENRE(
    id UUID default uuid_generate_v4(),
    genreId UUID,
    readListId UUID,
    primary key(id)

 );

  create table IS_AVAILABLE_IN(
      id UUID default uuid_generate_v4(),

      tierNumber bigint,
      creationId UUID,
      discountForSaleCreation number,

      primary key(id)
  );

   create table INTERESTED_IN(
       id UUID default uuid_generate_v4(),
       readerId UUID,
       genreId UUID,
       primary key(id)
   );

 create table BELONGS(
     id UUID default uuid_generate_v4(),

     genreId UUID,
     creationId UUID,

     primary key(id)
 );

-- create table MAKE (
--     orderId UUID default uuid_generate_v4(),
--     readerId bigint not null,
--     primary key(orderId)
-- );

-- create table ADDRESS(
--     userId UUID default uuid_generate_v4(),
--     country varchar (250),
--     city varchar(100),
--     street varchar(100),
--     state varchar
-- );


-- create table TAGS(
--     creationId UUID default uuid_generate_v4(),
--     tag varchar (50)
-- );



-- create table JOIN(
--     readerId UUID default uuid_generate_v4(),
--     creatorId UUID default uuid_generate_v4(),
--     tierNumber bigint,
--     joinDate date
-- );





-- create table REPLY(
--     commentId UUID,
--     replyDate date,
--     parentCommentId UUID
-- );










-- create table COMPOSE(
--     creationId UUID,
--     creatorId UUID
-- );





