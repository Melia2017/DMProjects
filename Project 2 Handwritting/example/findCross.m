function cross=findCross(A,B,C,D)
% �ҵ�AB��CD�Ľ���
AA=[A(2)-B(2), -(A(1)-B(1)); C(2)-D(2), -(C(1)-D(1))];
bb=[B(1)*A(2)-A(1)*B(2); D(1)*C(2)-C(1)*D(2)];
if(det(AA)~=0)
    cross=(AA\bb)';
else
    cross=A;
end

end