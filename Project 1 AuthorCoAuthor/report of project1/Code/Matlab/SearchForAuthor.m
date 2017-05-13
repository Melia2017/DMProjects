function [ relevantKeywords,relevantAuthors  ] = SearchForAuthor( AuthorName, numOfData)
conna=database('cleanData','','');
curs=exec(conna,['select KeywordsAll.[keywords] from [AuthorID_ClassID],[WordsID_ClassID],[KeywordsAll],[Authors] where [WordsID_ClassID].[WordsID]=[KeywordsAll].[ID] and [AuthorID_ClassID].[ClassID]=[WordsID_ClassID].[ClassID] and [AuthorID_ClassID].[AuthorID]=[Authors].[ID] and [Authors].[Author]=''',AuthorName,'''']);
curs=fetch(curs,numOfData);
relevantKeywords=curs.Data;

curs=exec(conna,['select Authors2.Author from AuthorID_ClassID,AuthorID_ClassID as AuthorID_ClassID2, Authors,Authors as Authors2 where Authors2.ID=AuthorID_ClassID2.AuthorID and AuthorID_ClassID2.ClassID=AuthorID_ClassID.ClassID and Authors.ID=AuthorID_ClassID.AuthorID and Authors.Author=''',AuthorName,'''']);
curs=fetch(curs,numOfData);
relevantAuthors=curs.Data;

end

