clc;
clear;
file_path='C:\Users\Xingchen Yang\Desktop\image_segment\';
Pic_list=dir(strcat(file_path,'*.jpg'));
Pic_name=Pic_list(1).name;
I=imread(strcat(file_path,Pic_name));
I=rgb2gray(I);
thresh=graythresh(I);
I=im2bw(I,thresh);
[h0,w0]=size(I);
name_net=Pic_name(1:end-4);
counter_1=[];
for i=1:1:h0
    counter_1(i)=0;
    for j=1:1:w0
        if I(i,j)==0
            counter_1(i)=counter_1(i)+1;
        end
    end
end

row=[];
j=1;
row(1)=1;

for i=1:1:h0
    if counter_1(i)<3
        j=j+1;
        row(j)=i;
    end
end
row(j+1)=h0;

num_1=0;
for k=1:1:j
    if row(k+1)-row(k)>40
        num_1=num_1+1;
        a=row(k);
        b=row(k+1);
        eval(['R_' ,num2str(num_1),'=I(a:b,1:w0);']);
    end
end

for m=1:1:num_1
    R=eval(['R_',num2str(m),';']);
    [h1,w1]=size(R);
    counter_2=[];
    for y=1:1:w1
        counter_2(y)=0;
        for x=1:1:h1
            if R(x,y)==0
                counter_2(y)=counter_2(y)+1;
            end
        end
    end
    col=[];
    n=1;
    for y=1:1:w1
        if counter_2(y)==0
            col(n)=y;
            n=n+1;
        end
    end
    col(n)=w1;
    num_2=0;
    for s=2:1:n
        if col(s)-col(s-1)>14
            num_2=num_2+1;
            a1=col(s-1);
            b1=col(s);
            str=[name_net,'_',int2str(m),'_',int2str(num_2)];
            imwrite(imresize(R(1:h1,a1:b1),[40,40]),strcat('C:\Users\Xingchen Yang\Desktop\results\',name_net,'\',str,'.jpg'));
        end
    end
end
            
    
    
    
        

          
