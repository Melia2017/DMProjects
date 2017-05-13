function PixValue = interp4P( p,Image )
% 图像4点插值
[height,width,depth]=size(Image);
r=p(1);
c=p(2);
if(1<=r && r<height && 1<=c && c<width)
    % 取原图左上的最临近的点坐标
    r1=floor(r);
    c1=floor(c);
    a=r-r1;
    b=c-c1;
%     PixValue=b*(a*Image(r1,c1,:)+(1-a)*Image(r1,c1+1,:))+(1-b)*(a*Image(r1+1,c1,:)+(1-a)*Image(r1+1,c1+1,:));
    PixValue=a*(b*Image(r1,c1,:)+(1-b)*Image(r1,c1+1,:))+(1-a)*(b*Image(r1+1,c1,:)+(1-b)*Image(r1+1,c1+1,:));
elseif(height<=r && r<height+1 && 1<=c && c<width)
    c1=floor(c);
    b=c-c1;
    PixValue=b*Image(height,c1,:)+(1-b)*Image(height,c1+1,:);
elseif(1<=r && r<height && width<=c && c<width+1)
    r1=floor(r);
    a=r-r1;
    PixValue=a*Image(r1,width,:)+(1-a)*Image(r1+1,width,:);
elseif(height<=r && r<height+1 && width<=c && c<width+1)    
    PixValue=Image(height,width,:);
elseif(0<=r && r<1 && 1<=c && c<=width)
    c1=floor(c);
    b=c-c1;
    PixValue=b*Image(1,c1,:)+(1-b)*Image(1,c1+1,:);
elseif(0<=c && c<1 && 1<=r && r<=height)
    r1=floor(r);
    a=r-r1;
    PixValue=a*Image(r1,1,:)+(1-a)*Image(r1+1,1,:);
elseif(0<=r && r<1 && 0<=c && c<1)    
    PixValue=Image(1,1,:);
else
    PixValue=zeros(size(Image(1,1,:)));
end

end