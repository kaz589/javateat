package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Airports") // 對應的資料表名稱
@Data // 包含 @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Airports {

    @Id // 主鍵
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自動生成 ID
    private int AirportsId; // 機場 ID

    private String IataCode; // 機場代碼
    private String AirportName; // 機場名稱
    private String CountryRegion; // 機場所處國家
    private String City; // 機場所處城市
}
