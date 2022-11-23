package com.example.webtruyen;

import com.example.webtruyen.Core.Domain.Entity.Truyen.TheLoai;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Core.Domain.Entity.User.Permission;
import com.example.webtruyen.Core.Domain.Entity.User.Role;
import com.example.webtruyen.Core.Domain.Entity.User.User;
import com.example.webtruyen.Infrastructure.ServiceIpl.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class WebTruyenApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebTruyenApplication.class, args);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    CommandLineRunner runner(UserService userService, RoleService roleService, PermissionService permissionService, TheLoaiService theLoaiService, TruyenService truyenService){
    return args -> {
        roleService.saveRole(new Role("ROLE_ADMIN","ROLE_ADMIN","ADMIN"));
        roleService.saveRole(new Role("ROLE_USER","ROLE_USER","USER"));
        roleService.saveRole(new Role("ROLE_SUPER_ADMIN","ROLE_SUPER_ADMIN","SUPER_ADMIN"));

        userService.saveUser(new User("khiem171222@gmail.com","admin","admin","admin","admin"));
        userService.saveUser(new User("tmp1@gmail.com", "tmp1", "tmp1", "tmp", "1"));
        userService.saveUser(new User("tmp2@gmail.com", "tmp2", "tmp2", "tmp", "2"));
        userService.saveUser(new User("tmp3@gmail.com", "tmp3", "tmp3", "tmp", "3"));
        userService.saveUser(new User("tmp4@gmail.com", "tmp4", "tmp4", "tmp", "4"));
        userService.saveUser(new User("tmp5@gmail.com", "tmp5", "tmp5", "tmp", "5"));
        userService.saveUser(new User("tmp6@gmail.com", "tmp6", "tmp6", "tmp", "6"));


        permissionService.savePermission(new Permission("user:add"));
        permissionService.savePermission(new Permission("user:edit"));
        permissionService.savePermission(new Permission("user:lockAndUnlock"));


        userService.addRoleToUser("admin","ROLE_SUPER_ADMIN");
        userService.addPermissionToRole("ROLE_SUPER_ADMIN","user:add");
        userService.addPermissionToRole("ROLE_SUPER_ADMIN","user:edit");
        userService.addPermissionToRole("ROLE_SUPER_ADMIN","user:lockAndUnlock");

        theLoaiService.themTheLoai("Kiem_Hiep");
        theLoaiService.themTheLoai("Sac_Hiep");
        theLoaiService.themTheLoai("Ngon_Tinh");
        theLoaiService.themTheLoai("Huyen_Huyen");
        theLoaiService.themTheLoai("Hai_Huoc");
//
//        truyenService.saveTruyenByAdmin(
//                new Truyen(
//                        "12_Nu_Than_1",
//                        "Câu chuyện kể về một lão già 69 tuổi tên Dương. Lão Dương đeo tai nghe, trốn trong nhà xem JAV như thường lệ, bật âm thanh lớn đến nỗi dù có tiếng máy bay ầm ầm ập tới, ngoài đường người người nháo nhào la hét thất thanh mà lão chẳng hề nghe thấy, chỉ chăm chăm vừa xem sex vừa quay tay.\n" +
//                                "RẦM!\n" +
//                                "Chiếc máy bay đâm thẳng vào nhà lão Dương, lão chết tươi.\n" +
//                                "Linh hồn lão Dương bay xuyên thời gian rồi nhập vào một người trung niên.\n" +
//                                "\"DÂM TẶC! CHÉM CHẾT MẸ NÓ ĐI!\"\n" +
//                                "\"THẺO DÁI NÓ! DÁM HIẾP DÂM TIỂU THƯ NHÀ LÀNH!\"\n" +
//                                "Trước mắt lão Dương là một khoảng sân rộng với hàng trăm người ăn mặc như cosplay cổ trang đang đứng hô hào phẫn nộ, hình như là nhằm về phía lão. Lúc này lão Dương mới phát hiện tay mình bị trói chặt, chân thì quỳ trên sàn gỗ không thể nhúc nhích.\n" +
//                                "Phập một cái, cảnh vật trước mắt lão Dương chợt nghiêng ngã rồi tối dần, đầu lão bay lìa khỏi cổ.\n" +
//                                "Sau đó, lão Dương lại chết, rồi mở mắt ra đã thấy mình nằm dưới một vách đá, trong cơ thể nhỏ nhắn xinh xắn của một mỹ thiếu niên.\n" +
//                                "Lão xuyên không rồi."),
//                        "Slaydark");
//        truyenService.saveTruyenByAdmin(
//                new Truyen(
//                        "12_Nu_Than_2",
//                        "Câu chuyện kể về một lão già 69 tuổi tên Dương. Lão Dương đeo tai nghe, trốn trong nhà xem JAV như thường lệ, bật âm thanh lớn đến nỗi dù có tiếng máy bay ầm ầm ập tới, ngoài đường người người nháo nhào la hét thất thanh mà lão chẳng hề nghe thấy, chỉ chăm chăm vừa xem sex vừa quay tay.\n" +
//                                "RẦM!\n" +
//                                "Chiếc máy bay đâm thẳng vào nhà lão Dương, lão chết tươi.\n" +
//                                "Linh hồn lão Dương bay xuyên thời gian rồi nhập vào một người trung niên.\n" +
//                                "\"DÂM TẶC! CHÉM CHẾT MẸ NÓ ĐI!\"\n" +
//                                "\"THẺO DÁI NÓ! DÁM HIẾP DÂM TIỂU THƯ NHÀ LÀNH!\"\n" +
//                                "Trước mắt lão Dương là một khoảng sân rộng với hàng trăm người ăn mặc như cosplay cổ trang đang đứng hô hào phẫn nộ, hình như là nhằm về phía lão. Lúc này lão Dương mới phát hiện tay mình bị trói chặt, chân thì quỳ trên sàn gỗ không thể nhúc nhích.\n" +
//                                "Phập một cái, cảnh vật trước mắt lão Dương chợt nghiêng ngã rồi tối dần, đầu lão bay lìa khỏi cổ.\n" +
//                                "Sau đó, lão Dương lại chết, rồi mở mắt ra đã thấy mình nằm dưới một vách đá, trong cơ thể nhỏ nhắn xinh xắn của một mỹ thiếu niên.\n" +
//                                "Lão xuyên không rồi."),
//                "Slaydark");
//        truyenService.saveTruyenByAdmin(
//                new Truyen(
//                        "12_Nu_Than_3",
//                        "Câu chuyện kể về một lão già 69 tuổi tên Dương. Lão Dương đeo tai nghe, trốn trong nhà xem JAV như thường lệ, bật âm thanh lớn đến nỗi dù có tiếng máy bay ầm ầm ập tới, ngoài đường người người nháo nhào la hét thất thanh mà lão chẳng hề nghe thấy, chỉ chăm chăm vừa xem sex vừa quay tay.\n" +
//                                "RẦM!\n" +
//                                "Chiếc máy bay đâm thẳng vào nhà lão Dương, lão chết tươi.\n" +
//                                "Linh hồn lão Dương bay xuyên thời gian rồi nhập vào một người trung niên.\n" +
//                                "\"DÂM TẶC! CHÉM CHẾT MẸ NÓ ĐI!\"\n" +
//                                "\"THẺO DÁI NÓ! DÁM HIẾP DÂM TIỂU THƯ NHÀ LÀNH!\"\n" +
//                                "Trước mắt lão Dương là một khoảng sân rộng với hàng trăm người ăn mặc như cosplay cổ trang đang đứng hô hào phẫn nộ, hình như là nhằm về phía lão. Lúc này lão Dương mới phát hiện tay mình bị trói chặt, chân thì quỳ trên sàn gỗ không thể nhúc nhích.\n" +
//                                "Phập một cái, cảnh vật trước mắt lão Dương chợt nghiêng ngã rồi tối dần, đầu lão bay lìa khỏi cổ.\n" +
//                                "Sau đó, lão Dương lại chết, rồi mở mắt ra đã thấy mình nằm dưới một vách đá, trong cơ thể nhỏ nhắn xinh xắn của một mỹ thiếu niên.\n" +
//                                "Lão xuyên khô" +
//                                "ng rồi."),
//                "Slaydark");
//        truyenService.saveTruyenByAdmin(
//                new Truyen(
//                        "12_Nu_Than_4",
//                        "Câu chuyện kể về một lão già 69 tuổi tên Dương. Lão Dương đeo tai nghe, trốn trong nhà xem JAV như thường lệ, bật âm thanh lớn đến nỗi dù có tiếng máy bay ầm ầm ập tới, ngoài đường người người nháo nhào la hét thất thanh mà lão chẳng hề nghe thấy, chỉ chăm chăm vừa xem sex vừa quay tay.\n" +
//                                "RẦM!\n" +
//                                "Chiếc máy bay đâm thẳng vào nhà lão Dương, lão chết tươi.\n" +
//                                "Linh hồn lão Dương bay xuyên thời gian rồi nhập vào một người trung niên.\n" +
//                                "\"DÂM TẶC! CHÉM CHẾT MẸ NÓ ĐI!\"\n" +
//                                "\"THẺO DÁI NÓ! DÁM HIẾP DÂM TIỂU THƯ NHÀ LÀNH!\"\n" +
//                                "Trước mắt lão Dương là một khoảng sân rộng với hàng trăm người ăn mặc như cosplay cổ trang đang đứng hô hào phẫn nộ, hình như là nhằm về phía lão. Lúc này lão Dương mới phát hiện tay mình bị trói chặt, chân thì quỳ trên sàn gỗ không thể nhúc nhích.\n" +
//                                "Phập một cái, cảnh vật trước mắt lão Dương chợt nghiêng ngã rồi tối dần, đầu lão bay lìa khỏi cổ.\n" +
//                                "Sau đó, lão Dương lại chết, rồi mở mắt ra đã thấy mình nằm dưới một vách đá, trong cơ thể nhỏ nhắn xinh xắn của một mỹ thiếu niên.\n" +
//                                "Lão xuyên không rồi."),
//                "Slaydark");
//        truyenService.saveTruyenByAdmin(
//                new Truyen(
//                        "12_Nu_Than_5",
//                        "Câu chuyện kể về một lão già 69 tuổi tên Dương. Lão Dương đeo tai nghe, trốn trong nhà xem JAV như thường lệ, bật âm thanh lớn đến nỗi dù có tiếng máy bay ầm ầm ập tới, ngoài đường người người nháo nhào la hét thất thanh mà lão chẳng hề nghe thấy, chỉ chăm chăm vừa xem sex vừa quay tay.\n" +
//                                "RẦM!\n" +
//                                "Chiếc máy bay đâm thẳng vào nhà lão Dương, lão chết tươi.\n" +
//                                "Linh hồn lão Dương bay xuyên thời gian rồi nhập vào một người trung niên.\n" +
//                                "\"DÂM TẶC! CHÉM CHẾT MẸ NÓ ĐI!\"\n" +
//                                "\"THẺO DÁI NÓ! DÁM HIẾP DÂM TIỂU THƯ NHÀ LÀNH!\"\n" +
//                                "Trước mắt lão Dương là một khoảng sân rộng với hàng trăm người ăn mặc như cosplay cổ trang đang đứng hô hào phẫn nộ, hình như là nhằm về phía lão. Lúc này lão Dương mới phát hiện tay mình bị trói chặt, chân thì quỳ trên sàn gỗ không thể nhúc nhích.\n" +
//                                "Phập một cái, cảnh vật trước mắt lão Dương chợt nghiêng ngã rồi tối dần, đầu lão bay lìa khỏi cổ.\n" +
//                                "Sau đó, lão Dương lại chết, rồi mở mắt ra đã thấy mình nằm dưới một vách đá, trong cơ thể nhỏ nhắn xinh xắn của một mỹ thiếu niên.\n" +
//                                "Lão xuyên không rồi."),
//                "Slaydark");
//        truyenService.saveTruyenByAdmin(
//                new Truyen(
//                        "12_Nu_Than_6",
//                        "Câu chuyện kể về một lão già 69 tuổi tên Dương. Lão Dương đeo tai nghe, trốn trong nhà xem JAV như thường lệ, bật âm thanh lớn đến nỗi dù có tiếng máy bay ầm ầm ập tới, ngoài đường người người nháo nhào la hét thất thanh mà lão chẳng hề nghe thấy, chỉ chăm chăm vừa xem sex vừa quay tay.\n" +
//                                "RẦM!\n" +
//                                "Chiếc máy bay đâm thẳng vào nhà lão Dương, lão chết tươi.\n" +
//                                "Linh hồn lão Dương bay xuyên thời gian rồi nhập vào một người trung niên.\n" +
//                                "\"DÂM TẶC! CHÉM CHẾT MẸ NÓ ĐI!\"\n" +
//                                "\"THẺO DÁI NÓ! DÁM HIẾP DÂM TIỂU THƯ NHÀ LÀNH!\"\n" +
//                                "Trước mắt lão Dương là một khoảng sân rộng với hàng trăm người ăn mặc như cosplay cổ trang đang đứng hô hào phẫn nộ, hình như là nhằm về phía lão. Lúc này lão Dương mới phát hiện tay mình bị trói chặt, chân thì quỳ trên sàn gỗ không thể nhúc nhích.\n" +
//                                "Phập một cái, cảnh vật trước mắt lão Dương chợt nghiêng ngã rồi tối dần, đầu lão bay lìa khỏi cổ.\n" +
//                                "Sau đó, lão Dương lại chết, rồi mở mắt ra đã thấy mình nằm dưới một vách đá, trong cơ thể nhỏ nhắn xinh xắn của một mỹ thiếu niên.\n" +
//                                "Lão xuyên không rồi."),
//                "Slaydark");
        };


    }
}
