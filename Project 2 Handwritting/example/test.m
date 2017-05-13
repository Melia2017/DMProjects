clear;
clc;

oriImage=imread('testImage.jpg');
G = fspecial('gaussian', [2 2], 1);
midImage = imfilter(oriImage,G,'replicate');

height=140;
width=440;
[~,~,depth]=size(oriImage);
P=[0 height height 0;
   0 0 width width];
P1=[4 114 159 35;
    5 5 330 335];
cross1=findCross(P1(:,1),P1(:,2),P1(:,3),P1(:,4));
cross2=findCross(P1(:,1),P1(:,4),P1(:,3),P1(:,2));
newImage=zeros(height,width,depth);
for i=1:height
    for j=1:width
        p14=[j/width*(P1(1,4)-P1(1,1))+P1(1,1); j/width*(P1(2,4)-P1(2,1))+P1(2,1)];
        p12=[i/height*(P1(1,2)-P1(1,1))+P1(1,1); i/height*(P1(2,2)-P1(2,1))+P1(2,1)];
        p=findCross(cross1,p14,cross2,p12);
        newImage(i,j,:) = interp4P( p,midImage );
    end
end
figure;imshow(oriImage)
figure;imshow(uint8(newImage))