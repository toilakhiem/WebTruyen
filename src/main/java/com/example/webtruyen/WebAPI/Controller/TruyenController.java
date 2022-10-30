package com.example.webtruyen.WebAPI.Controller;

import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Infrastructure.Repositories.Truyen.TruyenRepo;
//import com.example.webtruyen.Infrastructure.ServiceIpl.TruyenService;
import com.example.webtruyen.Infrastructure.ServiceIpl.TruyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("truyen")
public class TruyenController {
    @Autowired
    private TruyenService truyenService;

    @GetMapping("/getTruyen/{tenTruyen}")
    public ResponseEntity<Truyen> getTruyen(@PathVariable String tenTruyen){

        return ResponseEntity.ok().body(truyenService.getTruyen(tenTruyen));
    }
    @PostMapping("/postByAdmin")
    public ResponseEntity<?> DangTruyen(Truyen truyen){
        return ResponseEntity.ok().body(truyenService.saveTruyen(truyen));
    }
    @PostMapping("/post")
    public ResponseEntity<?>
}
