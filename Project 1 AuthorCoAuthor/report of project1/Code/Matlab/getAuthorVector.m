conna=database('cleanData','','');
curs=exec(conna,'select * from AuthorID_Vector');
% curs=exec(conna,'select * from 表1');

AuthorID_Vector=zeros(130516,100);

cnt=0;
while(true)
    curs=fetch(curs,1);
    Data=curs.Data;%把读取到的数据用变量Data保存.
    
    if(strcmp(Data{1},'No Data'))
        break;
    end
    
    AuthorID_Vector(Data{1,1},Data{1,2})=Data{1,3};
    cnt=cnt+1;
    disp(['完成:',num2str(cnt),'/517798(',num2str(cnt/517798*100),'%)']);
end