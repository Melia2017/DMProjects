load('AuthorID_Vector1.mat');
load('WordsID_Vector1.mat');
WordsID_Vector=WordsID_Vector./repmat(sum(WordsID_Vector.^2,2),1,size(WordsID_Vector,2));
AuthorID_Vector=AuthorID_Vector./repmat(sum(AuthorID_Vector.^2,2),1,size(AuthorID_Vector,2));
AuthorID_Vector(isnan(AuthorID_Vector))=0;
WordsID_Vector(isnan(WordsID_Vector))=0;