conna=database('cleanData','','');
curs=exec(conna,'select * from WordsID_Vector');
% curs=exec(conna,'select * from ��1');

WordsID_Vector=zeros(5061,100);

cnt=0;
while(true)
    curs=fetch(curs,1);
    Data=curs.Data;%�Ѷ�ȡ���������ñ���Data����.
    
    if(strcmp(Data{1},'No Data'))
        break;
    end
    
    WordsID_Vector(Data{1,1},Data{1,2})=Data{1,3};
    cnt=cnt+1;
    disp(['���:',num2str(cnt),'/159199(',num2str(cnt/159199*100),'%)']);
end