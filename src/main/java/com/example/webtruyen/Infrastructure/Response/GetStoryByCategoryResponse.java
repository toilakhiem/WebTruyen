package com.example.webtruyen.Infrastructure.Response;

import com.example.webtruyen.Core.Domain.Common.StatusStory;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Chapter;
import com.example.webtruyen.Core.Domain.Entity.Truyen.TheLoai;
import com.example.webtruyen.Core.Domain.Entity.Truyen.Truyen;
import com.example.webtruyen.Core.Domain.Entity.User.User;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Data
public class GetStoryByCategoryResponse {
    public String tenTruyen;
    public User tacGia;
    public String anhBia;
    public Long luotXem;
    public StatusStory trangThai;
    public float danhGia;
    public String motaNgan;
    public LocalDateTime lastUpdate;
    public List<Chapter> chapterList;
    public ArrayList<TheLoai> theLoais;
}
