INSERT INTO public.tb_cad_ent(
             tx_ent_nam)
    VALUES ('Conta Soma');


INSERT INTO public.tb_cad_emp(
             tx_emp_nam, tx_emp_rol, id_ent)
    VALUES ( 'Fulano da Silva', 'Desenvolvedor', 1);
    
INSERT INTO public.tb_cad_emp(
             tx_emp_nam, tx_emp_rol, id_ent)
    VALUES ( 'Cicrano Pereira', 'User Experience', 1);

INSERT INTO public.tb_cad_emp(
	     tx_emp_nam, tx_emp_rol, id_ent)
    VALUES ( 'Funcionario Alberto', 'Analista', 1);




INSERT INTO public.tb_cad_tra(
             dt_tra, tx_typ, vl_pay, id_ent)
    VALUES ('2019-01-01', 'WD', -450.00, 1);

INSERT INTO public.tb_cad_tra(
             dt_tra, tx_typ, vl_pay, id_ent)
    VALUES ('2019-01-01', 'WD', -450.00, 1);

INSERT INTO public.tb_cad_tra(
             dt_tra, tx_typ, vl_pay, id_ent)
    VALUES ('2019-01-01', 'WD', -450.00, 1);

INSERT INTO public.tb_cad_tra(
             dt_tra, tx_typ, vl_pay, id_ent)
    VALUES ('2019-01-01', 'PR', -50200.00, 1);

INSERT INTO public.tb_cad_tra(
             dt_tra, tx_typ, vl_pay, id_ent)
    VALUES ('2019-01-01', 'SL', 100700.00, 1);
