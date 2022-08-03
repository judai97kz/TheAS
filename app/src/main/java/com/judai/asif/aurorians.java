package com.judai.asif;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.judai.asif.ele.fireele;
import com.judai.asif.ele.forestele;
import com.judai.asif.ele.home;
import com.judai.asif.ele.thunderele;
import com.judai.asif.ele.waterele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class aurorians extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int fghome = 0;
    private static final int fgfire = 1;
    private static final int fgwater = 2;
    private static final int fgforest = 3;
    private static final int fgthunder = 4;

    private int mCu = fghome;

    private DrawerLayout drawerLayout;


    ListView lsau;
    ArrayList<AUs> arrayList;
    AuAdapter adapter;
    EditText editText;
    Button tim;

    public static ArrayList<AUs> redls;
    public static ArrayList<AUs> bluels;
    public static ArrayList<AUs> greenls;
    public static ArrayList<AUs> yellowls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aurorians);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        AnhXa();
        adapter = new AuAdapter(this,arrayList,R.layout.au_row);
        lsau.setAdapter(adapter);
        lsau.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AUs s = arrayList.get(i);
                Intent intent = new Intent(aurorians.this,AUinfo.class);
                intent.putExtra("user",s);
                startActivity(intent);
            }
        });
        editText = findViewById(R.id.etau);
        tim = findViewById(R.id.tim);
        tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenau = editText.getText().toString();
                char[] charArray = tenau.toCharArray();
                boolean foundSpace = true;
                for(int i = 0; i < charArray.length; i++) {
                    if(Character.isLetter(charArray[i])) {
                        if(foundSpace) {
                            charArray[i] = Character.toUpperCase(charArray[i]);
                            foundSpace = false;
                        }
                    }
                    else {
                        foundSpace = true;
                    }
                }
                // chuyển đổi mảng char thành string
                tenau = String.valueOf(charArray);
                locate(arrayList,tenau);
            }
        });
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.home)
        {
            if(mCu != fghome)
            {
                replacefragment(new home());
                mCu=fghome;
            }
        }else if (id == R.id.fire){
            if(mCu != fgfire)
            {
                replacefragment(new fireele());
                mCu=fgfire;
            }
        }else if(id == R.id.water)
        {
            if(mCu != fgwater)
            {
                replacefragment(new waterele());
                mCu=fgwater;
            }
        }else if(id == R.id.forest)
        {
            if(mCu != fgforest)
            {
                replacefragment(new forestele());
                mCu=fgforest;
            }
        }else if(id == R.id.thunder) {
            if(mCu != fgthunder)
            {
                replacefragment(new thunderele());
                mCu=fgthunder;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        {
            super.onBackPressed();
        }
    }
    private void replacefragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame,fragment);
        fragmentTransaction.commit();
    }

    public void locate(ArrayList<AUs> arrayList , String target)
    {
        for(int i=0;i < arrayList.size();i++)
        {
            if(arrayList.get(i).get_name().equals(target)==true)
            {
                AUs s = arrayList.get(i);
                Intent intent = new Intent(aurorians.this,AUinfo.class);
                intent.putExtra("user",s);
                startActivity(intent);
                break;
            }
            if(i == arrayList.size() - 1 && arrayList.get(i).get_name().equals(target)==false)
            {
                Toast.makeText(aurorians.this,"Tên Aurorian không tồn tại ! Hãy nhập lại !",Toast.LENGTH_LONG).show();
            }
        }
    }
    private void AnhXa()
    {
        lsau = findViewById(R.id.lsau);
        arrayList = new ArrayList<>();
        //Alice
        arrayList.add(new AUs("4*","Alice","Hỗ Trợ","Lửa","",R.drawable.alice,"Hiệp sĩ & Nữ hoàng (Kich hoạt) \n Giảm 40% sát thương tiếp theo trong vòng này và ngay lập tức hồi 10% HP đã mất của đồng đội khi nhận sát thương . Mức giảm sát thương và lượng HP hồi phục không được vượt quá 2 lần HP tối đa của Alice .","Điệu nhảy của búp bê (chuỗi combo) \n -5 : Phục hồi HP của đội bằng 160% sức công của Alice . \n -10 : Hồi phục lượng HP của đội bằng 220% sức công của Alice .","Chuyến đi đến xứ sở thần tiên (Trang bị) \n Nếu HP đã được hồi trong vòng này , thủ cơ bản của Alice tăng thêm 50% cho vòng này .",R.drawable.alicesk1,R.drawable.alicesk2,R.drawable.alicesk3,"MAX STA- Công : 2863 - Thủ : 1130 - Sinh Lực : 8709"));
//Allura
        arrayList.add(new AUs("5*","Allura","Xạ Thủ","Nước","Điện",R.drawable.allura,"Vỡ mộng (Kích hoạt) \n Gây 200% sát thương lên 17 ô có hình dạng xuyên tâm ở giữa 1 ô đã chọn. Sát thương gây ra cho ô đã chọn bỏ qua DEF. Xóa các hiệu ứng gạch bị hư hỏng khỏi các ô trong khoảng thời gian này. Khi Blessing đạt đến 10 điểm cộng dồn, phạm vi kỹ năng hoạt động sẽ trở thành khoảng cách hình xuyên tâm tối đa .","Không có lối thoát (Chuỗi Combo) \n -4 : Gây 165% sát thương lên 2 kẻ địch trong vòng 3 cụm xung quanh . \n -9 : Gây 170% sát thương cho 3 kẻ địch trong 3 cụm xung quanh . \n -13 : Gây 175% sát thương cho 4 kẻ địch trong vòng 3 cụm xung quanh .","Sự ban phước của thời gian (Trang bị) \n Có thể nhận được Phước lành . Mỗi điểm cộng dồn Blessing tăng sát thương Kỹ năng Chủ động của Allura lên 10% .",R.drawable.allurask1,R.drawable.allurask2,R.drawable.allurask3,"MAX STA- Công : 3160 - Thủ : 1096 - Sinh Lực : 9363 "));
//Amemori
        arrayList.add(new AUs("6*","Amemori","Chuyển Đổi","Điện","Nước",R.drawable.amemori,"Dấu vết bóng tối (Kích hoạt)\n Tiêu thụ 2 điểm Ninja Power và chọn 1 ô có thể di chuyển để triệu hồi 1 thanh katana. Nếu một thanh katana đã tồn tại trên ô đã chọn, Amemori sẽ dịch chuyển đến ô đó ngay lập tức và lấy katana, nhận được 1 điểm Sức mạnh Ninja .","Không ngừng (Chuỗi Combo) \n -2 : Gây 160% sát thương lên 8 ô hình chữ thập .\n -8 : Gây 165% sát thương lên 12 ô hình kim cương và triệu hồi 1 thanh katana tại một ô có thể di chuyển ngẫu nhiên.\n -13 : Gây 170% sát thương lên kẻ địch trong 1 cụm xung quanh và hình chữ thập trong phạm vi tối đa và triệu hồi mỗi thanh kiếm 1 thanh katana tại 2 ô có thể di chuyển ngẫu nhiên.","Katana Slash (Trang bị) \n Sau khi dịch chuyển bằng Kỹ năng Chủ động, hãy lấy tất cả các thanh katana. Mỗi thanh katana gây 150% sát thương lên 1 kẻ địch gần nhất trong khi bỏ qua DEF của chúng. Khoảng cách càng xa, sát thương càng giảm (tối thiểu 20% sát thương ban đầu). Nếu ít nhất 4 katana được thu hồi, 1 thanh katana mới sẽ được triệu hồi. Khi Amemori trở thành Đội trưởng, cô nhận được 1 Sức mạnh Ninja . Kích hoạt tối đa 3 lần mỗi hiệp. Thay đổi đội trưởng cho trận chiến: +1 .",R.drawable.amemorisk1,R.drawable.amemorisk2,R.drawable.amemorisk3,"MAX STA- Công : 3600 - Thủ : 1304 - Sinh Lực : 9995"));
//Amy
        arrayList.add(new AUs("3*","Amy","Hỗ Trợ","Điện","",R.drawable.amy,"Biểu ngữ bình minh (Kích hoạt)\n Đặt biểu ngữ trên 1 ô đã chọn. Amy càng gần biểu ngữ, DEF của cô ấy càng tăng (lên đến 100% ). Biểu ngữ biến mất khi bị kẻ thù chạm vào.","Nguồn cảm hứng (Chuỗi Combo) \n -5 : Phục hồi HP của đội bằng 160% ATK của Amy.\n -10 : Phục hồi HP của đội bằng 220% ATK của Amy.","Dấu ấn thần thánh của ánh sáng (Trang bị) \n Nếu Biểu ngữ vẫn còn tồn tại vào cuối vòng, sẽ tái tạo HP của đội bằng 3 lần DEF của Amy..",R.drawable.amysk1,R.drawable.amysk2,R.drawable.amysk3,"MAX STA- Công : 2215 - Thủ : 848 - Sinh Lực : 6339"));
//Angel
        arrayList.add(new AUs("3*","Angel","Bộc Phá","Điện","",R.drawable.angel,"Sự phán xét của Thiên Chúa (Kích hoạt) \n Triệu hồi 12 tia sét, mỗi tia gây 180% sát thương lên một khu vực 2 × 2 ngẫu nhiên trên sân.","Vũ điệu lông vũ (Chuỗi Combo) \n -2 : Gây 150% sát thương lên 12 ô hình kim cương . \n -8 : Gây 150% sát thương cho 1 cụm xung quanh và kẻ địch theo hình chữ thập trong phạm vi tối đa .","Hạ cánh lông vũ (Trang bị) \n Mỗi tia chớp của Kỹ năng Chủ động có 15% cơ hội gây 100% sát thương.",R.drawable.angelsk1,R.drawable.angelsk2,R.drawable.angelsk3,"MAX STA- Công : 2373 - Thủ : 836 - Sinh Lực : 6762 "));
//Ansia
        arrayList.add(new AUs("4*","Ansia","Chuyển Đổi","Điện","",R.drawable.ansia,"Sóng âm (Kích hoạt) \n Điều khiển một thanh kiếm ma thuật, tăng 25% tấn công của đơn vị trong vòng này. Sau đó, giảm 50% ATK và DEF trong 1 hiệp. Đơn vị miễn nhiễm với các hiệu ứng trạng thái làm giảm ATK và DEF trong khi đơn vị đang điều khiển thanh kiếm ma thuật để giết kẻ thù.","Pulsating Quake (Chuỗi Combo) \n -4 : Gây 145% sát thương cho kẻ địch trong 3 cụm xung quanh (50% sát thương cho những kẻ ở cụm ngoài cùng). \n -8 : Gây 160% sát thương cho kẻ địch trong 3 cụm xung quanh (50% sát thương cho những kẻ ở cụm ngoài cùng).","Cạnh âm thanh (Trang bị) \n Tăng sát thương mà Ansia gây ra cho kẻ địch dọc theo rìa của chiến trường (sát thương cộng thêm cao nhất khi kẻ địch ở trong góc), lên tới 50% sát thương cuối cùng.",R.drawable.ansiask1,R.drawable.ansiask2,R.drawable.ansiask3,"MAX STA- Công : 2980 - Thủ : 1072 - Sinh Lực : 9122 "));
//Areia
        arrayList.add(new AUs("5*","Areia","Bộc Phá","Rừng","Nước",R.drawable.areia,"Enchanted Sword Apostle (Kích hoạt) \n Gây 200% sát thương lên 17 ô có hình dạng xuyên tâm ở giữa 1 ô đã chọn. Sát thương gây ra cho ô đã chọn bỏ qua DEF. Xóa các hiệu ứng gạch bị hư hỏng khỏi các ô trong khoảng thời gian này. Khi Blessing đạt đến 10 điểm cộng dồn, phạm vi kỹ năng hoạt động sẽ trở thành khoảng cách hình xuyên tâm tối đa .","Blackthorn (Chuỗi Combo) \n -2 : Gây 160% sát thương cho 1 cụm xung quanh . Khi điều khiển thanh kiếm ma thuật, Chain Combo sẽ giết kẻ thù có HP thấp hơn ATK của Areia 1,5 lần . \n -8 : Gây 165% sát thương trong khu vực 12 viên kim cương . Khi sử dụng thanh kiếm ma thuật, Chain Combo sẽ tiêu diệt kẻ thù có HP thấp hơn ATK x 1.5 của Areia . \n -12 : Gây 170% sát thương cho 2 cụm xung quanh . Khi điều khiển thanh kiếm ma thuật, Chain Combo sẽ giết kẻ thù có HP thấp hơn ATK của Areia 1,5 lần .","Lĩnh vực Lunar Thorn (Trang bị) \n Khi điều khiển ma kiếm, các đòn đánh thường sẽ xuyên qua kẻ địch, gây sát thương 100% lên mục tiêu 1 ô phía sau kẻ địch.",R.drawable.areiask1,R.drawable.areiask2,R.drawable.areiask3,"MAX STA- Công : 3405 - Thủ : 1343 - Sinh Lực : 10522 "));
//Barbara
        arrayList.add(new AUs("5*","Barbara","Hỗ Trợ","Lửa","Lửa",R.drawable.barbara,"Nụ hôn ngọt ngào (Kích hoạt) \n Gây 550% sát thương lên tất cả kẻ địch và làm choáng tất cả kẻ địch trên ô Đỏ. Kẻ địch trên ô khác có 35% khả năng bị choáng .","Hỗ trợ chữa cháy (Chuỗi Combo) \n -4 : Gây 145% sát thương lên 12 ô hình kim cương . \n -9 : Gây 150% sát thương lên 16 ô có hình dạng xuyên tâm . \n -12 : Gây 165% sát thương cho 2 cụm xung quanh .","Đi kèm hoàn hảo (Trang bị) \n Tăng 5% sát thương của tất cả các thành viên đã triển khai chống lại kẻ thù chiếm ô Đỏ .",R.drawable.barbarask1,R.drawable.barbarask2,R.drawable.barbarask3,"MAX STA- Công : 3106 - Thủ : 1125 - Sinh Lực : 9379 "));
//Barton
        arrayList.add(new AUs("5*","Barton","Chuyển Đổi","Nước","Điện",R.drawable.barton,"Cưa sắt! (Kích hoạt) \n Gây 450% sát thương lên kẻ địch theo hình chữ thập trong phạm vi tối đa và đánh bật kẻ thù trở lại. Chuyển đổi các ô trong khu vực bị tấn công thành Xanh lam.","Barton's Strike (Chuỗi Combo) \n -2 : Gây 155% sát thương cho 1 cụm xung quanh . \n -8 : Gây 155% sát thương lên 12 ô hình kim cương . \n -13 : Gây 160% sát thương cho 1 cụm xung quanh và kẻ địch theo hình chữ thập trong phạm vi tối đa .","Đuổi việc (Trang bị) \n Các đòn đánh thường giờ có thể bắn theo đường chéo để gây 80% sát thương và gây ra 1 Dấu hiệu hỏa lực kéo dài 2 hiệp. Đòn tấn công của Barton gây thêm 10% sát thương lên những kẻ địch có dấu ấn.",R.drawable.bartonsk1,R.drawable.bartonsk2,R.drawable.bartonsk3,"MAX STA- Công : 2522 - Thủ : 960 - Sinh Lực : 9379 "));
//Benny And Curo
        arrayList.add(new AUs("5*","Benny And Curo","Bộc Phá","Lửa","Rừng",R.drawable.bennyandcuro,"Rapid Blaze (Kích hoạt) \n Đánh dấu 1 ô. Khi số ô được kết nối đạt gấp 1,5 lần số ô cần thiết để kích hoạt Tổ hợp Chuỗi, hãy sử dụng Tổ hợp Chuỗi một lần tại vị trí được đánh dấu (tăng sát thương cuối cùng của cả hai Tổ hợp Chuỗi lên 30% ).","Ngọn lửa bốc cháy (Chuỗi Combo) \n -2 : Gây 140% sát thương cho 1 cụm xung quanh . \n -8 : Gây 145% sát thương lên 12 ô hình kim cương . \n -11 : Gây 155% sát thương lên 16 ô có hình dạng xuyên tâm .","Cuộc tấn công được che giấu (Trang bị) \n Đòn đánh thường gây thêm 60% sát thương lên kẻ địch chiếm ô Đỏ.",R.drawable.bennyandcurosk1,R.drawable.bennyandcurosk2,R.drawable.bennyandcurosk3,"MAX STA- Công : 3276 - Thủ : 1216 - Sinh Lực : 10214 "));
//Beryl
        arrayList.add(new AUs("6*","Beryl","Bộc Phá","Rừng","Lửa",R.drawable.beryl,"Miền pha lê (Kích hoạt) \n Gây sát thương 300% cho tất cả kẻ thù trên màn hình 1 lần. Số lượng kẻ thù trên bàn cờ càng ít, sát thương gây ra càng lớn, lên đến 160%. Sau khi sử dụng Kỹ năng chủ động và khi bước vào Thời gian cực quang , hãy đánh dấu vị trí hiện tại. Nếu một Kỹ năng Trang bị được kích hoạt tạo ra tinh thể trong vòng này, Kỹ năng Trang bị sẽ được kích hoạt 1 lần tại vị trí được đánh dấu.","Nở ẩn (Chuỗi Combo) \n -2 : Gây 145% sát thương cho 1 cụm xung quanh . \n -8 : Gây 160% sát thương lên 12 ô hình kim cương . \n -11 : Gây 165% sát thương lên 16 ô có hình dạng xuyên tâm .","Crystal Touch (Trang bị) \n Trước khi kẻ thù hành động, nếu Beryl tung ra Chuỗi kết hợp trong vòng này, các tinh thể sẽ được tạo ra dọc theo các ô trong khoảng kết hợp Chuỗi của cô ấy và sẽ ở đó trong 1 vòng. Khi kẻ địch tiếp xúc với tinh thể của cô ấy, chúng sẽ chịu sát thương bằng 40% TC của Beryl (sát thương này bỏ qua DEF). Sau khi kết nối 10 ô, sát thương pha lê tăng 100% cho mỗi ô bổ sung trên 10 ô, tối đa là 15 ô.",R.drawable.berylsk1,R.drawable.berylsk2,R.drawable.berylsk3,"MAX STA- Công : 3392 - Thủ : 1440 - Sinh Lực : 10015 "));
//Bethel
        arrayList.add(new AUs("6*","Bethel","Bộc Phá","Nước","Lửa",R.drawable.bethel,"Tindall's Fury (Kích hoạt) \n Gây 180% sát thương lên 5 ô hình chữ thập có tâm trên 1 ô có thể duyệt được chọn. Có thể sử dụng thêm 1 lần nữa sau khi vào Thời gian cực quang (có thể kích hoạt 1 lần mỗi đợt).","Quà tặng quang phổ (Chuỗi Combo) \n -4 : Gây 150% sát thương lên 12 ô hình kim cương . Nếu Frankel ở trong tầm bắn, Frankel dịch chuyển đến ô gạch cạnh kẻ thù gần nhất và tấn công. \n -9 : Gây 165% sát thương lên 16 ô có hình dạng xuyên tâm . Nếu Frankel ở trong tầm bắn, Frankel dịch chuyển đến ô gạch cạnh kẻ thù gần nhất và tấn công. \n -12 : Gây 175% sát thương cho 2 cụm xung quanh . Nếu Frankel ở trong tầm bắn, Frankel dịch chuyển đến ô gạch cạnh kẻ thù gần nhất và tấn công.","Frankel's Rage (Trang bị) \n Triệu hồi Frankel đến ô được chọn bởi Kỹ năng Chủ động của bạn. Mỗi khi một đơn vị sử dụng Kỹ năng Chủ động, Frankel sẽ tung ra một Tiếng gầm , gây 105% sát thương lên kẻ địch trong 1 cụm xung quanh . Nếu chỉ có một kẻ địch trong phạm vi, hãy tung ra Sundering Claw , tăng 50% sát thương . Frankel cũng phát ra tiếng gầm khi biến mất.",R.drawable.bethelsk1,R.drawable.bethelsk2,R.drawable.bethelsk3,"MAX STA- Công : 3496 - Thủ : 1175 - Sinh Lực : 9911 "));
//Bethlehem
        arrayList.add(new AUs("6*","Bethlehem","Chuyển Đổi","Nước","Nước",R.drawable.bethlehem,"Đóng băng tức thì (Kích hoạt) \n Chuyển 4 ô đã chọn bất kỳ thành Xanh lam.","Aurora Slash (Chuỗi Combo) \n -4 : Gây 150% sát thương lên 12 ô hình kim cương . \n -9 : Gây 155% sát thương lên 16 ô có hình dạng xuyên tâm . \n -13 : Gây 160% sát thương lên kẻ địch theo hình dạng xuyên tâm trong phạm vi tối đa .","Điện miền Bắc (Trang bị) \n Khi sử dụng Kỹ năng Chủ động hoặc bước vào Thời gian cực quang, ATK cơ bản của Bethlehem sẽ tăng thêm 10% trong vòng này và các Thần linh Nước khác cũng sẽ nhận được ATK tăng thêm 5% ATK cơ bản của Bethlehem.",R.drawable.bethlehemsk1,R.drawable.bethlehemsk2,R.drawable.bethlehemsk3,"MAX STA- Công : 2506 - Thủ : 943 - Sinh Lực : 7313 "));
//Beverly
        arrayList.add(new AUs("5*","Beverly","Chuyển Đổi","Điện","Điện",R.drawable.beverly,"Hoàn hảo (Kích hoạt) \n Chuyển 5 ô Đỏ gần nhất thành Vàng và có cơ hội tạo ra tối đa 2 ô nâng cao . Nếu Kỹ năng Chủ động đã sẵn sàng trong vòng trước, số lần chuyển đổi ô xếp +1 trong vòng này. ","Cuối cùng Pierce (Chuỗi Combo) \n -5 : Gây 130% sát thương cho 1 hàng . \n -9 : Gây 130% sát thương lên kẻ địch theo hình chữ thập trong phạm vi tối đa . \n -11 : Gây 135% sát thương lên kẻ địch theo hình chữ thập trong phạm vi tối đa .","Trường lực lượng sấm sét (Trang bị) \n Khi Tổ hợp Chuỗi bắn trúng mục tiêu, nó cũng gây sát thương lên 2 (các) mục tiêu ngẫu nhiên (mỗi mục tiêu chỉ có thể chịu sát thương một lần) trong 2 cụm xung quanh của mục tiêu. Sát thương giảm 0% với mỗi đòn đánh.",R.drawable.beverlysk1,R.drawable.beverlysk2,R.drawable.beverlysk3,"MAX STA- Công : 2525 - Thủ : 934 - Sinh Lực : 7844 "));
//Bonacie
        arrayList.add(new AUs("5*","Bonacie","Hỗ Trợ","Điện","Nước",R.drawable.bonacie,"Cộng hưởng thần thánh (Kích hoạt) \n Chọn 1 trong 4 hướng xung quanh đơn vị và dịch chuyển tất cả những kẻ địch không phải là trùm chiếm một ô đơn lẻ theo hướng đã chọn, đồng thời gây 250% sát thương cho tất cả kẻ địch trên bàn cờ. Nếu số lượng kẻ địch trúng phải là 2 hoặc ít hơn, kỹ năng này sẽ được sử dụng thêm 1 lần nữa trong vòng này.","Hòa hợp (Chuỗi Combo) \n -5 : Gây 130% sát thương cho 1 hàng . \n -9 : Gây 130% sát thương cho 3 hàng . \n -13 : Gây 145% sát thương cho 3 hàng .","Nhịp điệu hài hòa (Trang bị) \n Nhận Dấu ấn Thần thánh khi bắt đầu trận chiến hoặc khi sử dụng Kỹ năng Chủ động. Trong khi dấu hiệu này tồn tại, DEF của Bonacie tăng 120% . Dấu này biến mất khi Bonacie mất HP. Khi dấu ấn này tồn tại, sát thương của Chain Combo do Thần Sáng Sấm gây ra tăng thêm 10% .",R.drawable.bonaciesk1,R.drawable.bonaciesk2,R.drawable.bonaciesk3,"MAX STA- Công : 2896 - Thủ : 1005 - Sinh Lực : 9041 "));
//Sharona
        arrayList.add(new AUs("6*","Sharona","Bộc Phá","Nước","Lửa",R.drawable.sharona,"Nợ máu trả bằng máu (Kích hoạt) \n Dịch chuyển đến một vị trí đã chọn . Gây 300% sát thương cho 2 cụm xung quanh và áp dụng 2 điểm cộng dồn dấu ấn Dragontooth(áp dung số điểm cộng dồn Dấu ấn Dragontooh tối đa lên những kể địch trong khu vực khi giết kẻ địch .","Cơn thịnh nộ máu (Chuỗi combo) \n -2 : Gây 185% sát thương lên 8 ô hình chữ thập .\n-8 : Gây 190% sát thương lên 12 ô hình kim cương \n-13 : Gây 195% sát thương cho 1 cụm xung quanh và kẻ địch theo hình chữ thập trong phạm vi tối đa .","Hexing Gaze (Trang bị) \n Đòn đánh thường áp dụng 1 điểm cộng dồn Dấu Ấn Drangontooth , tối đa 6 điểm cộng dồn . Mỗi điểm cộng dồn  tăng sát thương Kỹ năng chủ động của Sharona và sát thương chuỗi kết hợp cuối cùng lên 5%.",R.drawable.sharonask1,R.drawable.sharonask2,R.drawable.sharonask3,"MAX STA- Công : 3614 - Thủ : 1375 - Sinh Lực : 10975"));
//Brock
        arrayList.add(new AUs("4*","Brock","Hỗ Trợ","Lửa","",R.drawable.brock,"Hấp thụ tuabin (Kích hoạt) \n Gây 300% sát thương cho tất cả kẻ thù và kết tập tất cả kẻ thù cho đơn vị. Sát thương cuối cùng tăng thêm 10% cho mỗi kẻ địch di chuyển trên ô vuông.","Cú đấm siêu tăng áp (Chuỗi Combo) \n -2 : Gây 155% sát thương cho 1 cụm xung quanh . \n -8 : Gây 170% sát thương lên 12 ô hình kim cương .","Tăng áp (Trang bị) \n Sau khi sử dụng Kỹ năng chủ động, tăng ATK của Fire Aurorian bằng 4% ATK của Brock cho mỗi kẻ địch trong vòng 2 cụm xung quanh của đơn vị.",R.drawable.brocksk1,R.drawable.brocksk2,R.drawable.brocksk3,"MAX STA- Công : 3053 - Thủ : 1267 - Sinh Lực : 9821 "));
//Carleen
        arrayList.add(new AUs("6*","Carleen","Chuyển Đổi","Nước","Nước",R.drawable.carleen,"Xuyên qua mạng che mặt (Kích hoạt) \n Dịch chuyển đến một vị trí đã chọn. Gây 300% sát thương lên 1 cột và đánh bật kẻ thù trở lại. Chuyển đổi các ô trong khu vực bị tấn công thành Xanh lam.","Bão tuyết (Chuỗi Combo) \n -2 : Gây 160% sát thương cho 1 cụm xung quanh. \n -8 : Gây 160% sát thương lên 12 ô hình kim cương. \n -13 : Gây 165% sát thương lên 1 cụm xung quanh và kẻ địch theo hình chữ thập trong phạm vi tối đa.","Băng tàn nhẫn (Trang bị) \n Carleen nhận thêm + 0,5% TC mỗi lần 1 viên Nước cô ấy di chuyển đến hoặc qua trong vòng (tối đa 10%). Hiệu ứng tăng gấp đôi cho một Kỹ năng chủ động. Các đòn đánh thường của cô ấy được Xỏ vào một ô Nước và gây 40% sát thương lên mục tiêu 1 ô phía sau kẻ thù.",R.drawable.carleensk1,R.drawable.carleensk2,R.drawable.carleensk3,"MAX STA- Công : 2896 - Thủ : 1048 - Sinh Lực : 8960 "));
//Chainsaw Rick
        arrayList.add(new AUs("3*","Chainsaw Rick","Hỗ Trợ","Lửa","",R.drawable.chainsawrick,"Cơn thịnh nộ thịnh nộ (Kích hoạt) \n Gây 300% sát thương cho 1 cụm xung quanh và kẻ địch theo hình chữ thập trong phạm vi tối đa và đánh bật kẻ thù trở lại.","Bão Diesel (Chuỗi Combo) \n -2 : Gây 150% sát thương lên 8 ô hình chữ thập và đánh bật kẻ thù trở lại. \n -7 : Gây 175% sát thương lên 12 ô hình chữ thập và đánh bật kẻ thù trở lại.","Trang bị thêm của Rediesel (Trang bị) \n Tăng 50% sát thương của Kỹ năng Chủ động .",R.drawable.chainsawricksk1,R.drawable.chainsawricksk2,R.drawable.chainsawricksk3,"MAX STA- Công : 2245 - Thủ : 823 - Sinh Lực : 6198 "));
//Chandra
        arrayList.add(new AUs("4*","Chandra","Xạ Thủ","Lửa","",R.drawable.chandra,"Dự án cảm xúc tiêu cực (Kích hoạt) \n Gây 180% sát thương lên kẻ địch trên 1 ô đã chọn. Loại bỏ thời gian hồi chiêu của Kỹ năng Chủ động nếu mục tiêu bị hạ gục bằng kỹ năng này."," (Chuỗi Combo) \n -4 : Gây 145% sát thương cho 3 kẻ địch trong vòng 2 cụm xung quanh . \n -8 : Gây 150% sát thương cho 3 kẻ địch trong vòng 3 cụm xung quanh .","Thu thập cảm xúc tiêu cực (Trang bị) \n Nhận 1 điểm cộng dồn Dấu hiệu tiêu cực bất cứ khi nào sử dụng Kỹ năng Chủ động, tối đa 5 điểm cộng dồn . Mỗi điểm cộng dồn tăng 1 lần tấn công Kỹ năng Chủ động, giảm 8% sát thương cuối cùng . Mỗi dấu hiệu tăng sát thương của Chain Combo lên 5% .",R.drawable.chandrask1,R.drawable.chandrask2,R.drawable.chandrask3,"MAX STA- Công : 3135 - Thủ : 1065 - Sinh Lực : 9026 "));
//Charon
        arrayList.add(new AUs("6*","Charon","Bộc Phá","Lửa","Rừng",R.drawable.charon,"Cuộc gọi của cơn ác mộng (Kích hoạt) \n Gây 300% sát thương cho 3 cột được chọn hoặc 3 hàng đã chọn và đánh bật kẻ thù trở lại. Sát thương gây ra cho hàng hoặc cột ở giữa sẽ bằng 1,5 lần sát thương gây ra cho hai bên. Đặt lại tất cả các ô không phải ô Đỏ trong khu vực bị tấn công và có một cơ hội nhỏ để tạo ô đỏ.","Dance of the Dead (Chuỗi Combo) \n -2 : Gây 170% sát thương cho 1 cụm xung quanh . \n -9 : Gây 175% sát thương lên 16 ô có hình dạng xuyên tâm . \n -12 : Gây 180% sát thương cho 2 cụm xung quanh .","Đường dây trực tiếp (Trang bị) \n Các đòn đánh thường giờ có thể tấn công theo đường chéo . Cộng thêm sát thương bỏ qua DEF bằng 10% ATK cho các đòn đánh thường.",R.drawable.charonsk1,R.drawable.charonsk2,R.drawable.charonsk3,"MAX STA- Công : 3331 - Thủ : 1236 - Sinh Lực : 10466 "));




        Collections.sort(arrayList, new Comparator<AUs>() {
            @Override
            public int compare(AUs sv1, AUs sv2) {
                return (sv1.get_name().compareTo(sv2.get_name()));
                // Muốn đảo danh sách các bạn đối thành
                //return (sv2.hoTen.compareTo(sv1.hoTen));
            }
        });
        gan();
    }

    private void gan(){
        redls = new ArrayList<>();
        bluels = new ArrayList<>();
        greenls = new ArrayList<>();
        yellowls = new ArrayList<>();
        for (int i=0;i<arrayList.size();i++)
        {
            if(arrayList.get(i).get_ele1().equals("Lửa")==true){
                redls.add(new AUs(arrayList.get(i).get_star(),arrayList.get(i).get_name(),arrayList.get(i).get_class(),arrayList.get(i).get_ele1(),arrayList.get(i).get_ele2(),arrayList.get(i).get_img(),arrayList.get(i).get_sk1(),arrayList.get(i).get_sk2(),arrayList.get(i).get_sk3(),arrayList.get(i).get_img1(),arrayList.get(i).get_img2(),arrayList.get(i).get_img3(),arrayList.get(i).get_info()));
            }
            if(arrayList.get(i).get_ele1().equals("Nước")==true){
                bluels.add(new AUs(arrayList.get(i).get_star(),arrayList.get(i).get_name(),arrayList.get(i).get_class(),arrayList.get(i).get_ele1(),arrayList.get(i).get_ele2(),arrayList.get(i).get_img(),arrayList.get(i).get_sk1(),arrayList.get(i).get_sk2(),arrayList.get(i).get_sk3(),arrayList.get(i).get_img1(),arrayList.get(i).get_img2(),arrayList.get(i).get_img3(),arrayList.get(i).get_info()));
            }
            if(arrayList.get(i).get_ele1().equals("Rừng")==true){
                greenls.add(new AUs(arrayList.get(i).get_star(),arrayList.get(i).get_name(),arrayList.get(i).get_class(),arrayList.get(i).get_ele1(),arrayList.get(i).get_ele2(),arrayList.get(i).get_img(),arrayList.get(i).get_sk1(),arrayList.get(i).get_sk2(),arrayList.get(i).get_sk3(),arrayList.get(i).get_img1(),arrayList.get(i).get_img2(),arrayList.get(i).get_img3(),arrayList.get(i).get_info()));
            }
            if(arrayList.get(i).get_ele1().equals("Điện")==true){
                yellowls.add(new AUs(arrayList.get(i).get_star(),arrayList.get(i).get_name(),arrayList.get(i).get_class(),arrayList.get(i).get_ele1(),arrayList.get(i).get_ele2(),arrayList.get(i).get_img(),arrayList.get(i).get_sk1(),arrayList.get(i).get_sk2(),arrayList.get(i).get_sk3(),arrayList.get(i).get_img1(),arrayList.get(i).get_img2(),arrayList.get(i).get_img3(),arrayList.get(i).get_info()));
            }
        }
    }
}