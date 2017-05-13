%词的分类
% [WordsIdx,WordsCenter]=kmeans(WordsID_Vector,20,'Start','uniform','Distance','cosine') ;
[Idx,C]=kmeans(WordsID_Vector(1:100,:),20,'Start',seeds,'Distance','cosine') ;
% [Idx,C]=kmeans(WordsID_Vector(1:100,:),10,'Start',seeds,'Distance','cosine') ;
% [Idx,C]=kmeans(WordsID_Vector(1:100,:),10,'Start','cluster','Display', 'final','Distance','cosine') ;
% [Idx,C]=kmeans(AuthorID_Vector,10) ;
figure;
histogram(WordsIdx,'BinWidth',1);
title('关键词的类别和计数');
xlabel('关键词类的索引（共20类）');
ylabel('各类的关键词数量');

%找到每一聚类前5的关键词ID
% index=zeros(100,5);
% for i=1:100
% %     [~,I] = sort(Words_Center(i,:),2,'descend');
%     I = find(WordsIdx==i);
%     index(i,:)=I(1:5);
% end

%作者的分类
[AuthorIdx,AuthorCenter]=kmeans(AuthorID_Vector,20,'Start',WordsCenter) ;
figure;
histogram(AuthorIdx,'BinWidth',1)
title('作者的类别和计数');
xlabel('作者类的索引（共20类）');
ylabel('各类的作者数量');