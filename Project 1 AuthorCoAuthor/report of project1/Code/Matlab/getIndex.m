%�ʵķ���
% [WordsIdx,WordsCenter]=kmeans(WordsID_Vector,20,'Start','uniform','Distance','cosine') ;
[Idx,C]=kmeans(WordsID_Vector(1:100,:),20,'Start',seeds,'Distance','cosine') ;
% [Idx,C]=kmeans(WordsID_Vector(1:100,:),10,'Start',seeds,'Distance','cosine') ;
% [Idx,C]=kmeans(WordsID_Vector(1:100,:),10,'Start','cluster','Display', 'final','Distance','cosine') ;
% [Idx,C]=kmeans(AuthorID_Vector,10) ;
figure;
histogram(WordsIdx,'BinWidth',1);
title('�ؼ��ʵ����ͼ���');
xlabel('�ؼ��������������20�ࣩ');
ylabel('����Ĺؼ�������');

%�ҵ�ÿһ����ǰ5�Ĺؼ���ID
% index=zeros(100,5);
% for i=1:100
% %     [~,I] = sort(Words_Center(i,:),2,'descend');
%     I = find(WordsIdx==i);
%     index(i,:)=I(1:5);
% end

%���ߵķ���
[AuthorIdx,AuthorCenter]=kmeans(AuthorID_Vector,20,'Start',WordsCenter) ;
figure;
histogram(AuthorIdx,'BinWidth',1)
title('���ߵ����ͼ���');
xlabel('���������������20�ࣩ');
ylabel('�������������');