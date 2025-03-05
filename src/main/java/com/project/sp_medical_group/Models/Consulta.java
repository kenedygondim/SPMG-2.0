package com.project.sp_medical_group.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.project.sp_medical_group.Enum.Role;
import com.project.sp_medical_group.Enum.SituacaoConsulta;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table("tb_consultas")
@Getter
@NoArgsConstructor
@ToString
public class Consulta {
    public Consulta(String disponibilidadeId, String especialidadeId, String descricao, SituacaoConsulta situacao, String pacienteCpf, boolean isTelemedicina) {
        this.disponibilidadeId = disponibilidadeId;
        this.especialidadeId = especialidadeId;
        this.descricao = descricao;
        this.situacao = situacao.getValor();
        this.pacienteCpf = pacienteCpf;
        this.isTelemedicina = isTelemedicina;
    }

    @Id
    @Column("consulta_id")
    private Integer consultaId;

    @Column("disponibilidade_id")
    private String disponibilidadeId;

    @Column("especialidade_id")
    private String especialidadeId;

    @Column("descricao")
    private String descricao;

    @Column("situacao")
    private String situacao;

    @Column("paciente_cpf")
    private String pacienteCpf;

    @Column("is_telemedicina")
    @Setter
    private boolean isTelemedicina;

    public SituacaoConsulta getSituacao() {
        return SituacaoConsulta.fromValor(situacao);
    }
    public void setSituacao(SituacaoConsulta situacao) {
        this.situacao = situacao.getValor();
    }
}
