import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query'
import { getGrips, getGrip, createGrip, updateGrip, deleteGrip, getAssessments, createAssessment, addAssessmentEntry } from '../api/client'
import type { Grip } from '../types'

export function useGrips() {
  return useQuery({ queryKey: ['grips'], queryFn: getGrips })
}

export function useGrip(id: number) {
  return useQuery({ queryKey: ['grips', id], queryFn: () => getGrip(id) })
}

export function useCreateGrip() {
  const qc = useQueryClient()
  return useMutation({
    mutationFn: (data: Omit<Grip, 'id'>) => createGrip(data),
    onSuccess: () => qc.invalidateQueries({ queryKey: ['grips'] }),
  })
}

export function useUpdateGrip() {
  const qc = useQueryClient()
  return useMutation({
    mutationFn: ({ id, data }: { id: number; data: Omit<Grip, 'id'> }) => updateGrip(id, data),
    onSuccess: () => qc.invalidateQueries({ queryKey: ['grips'] }),
  })
}

export function useDeleteGrip() {
  const qc = useQueryClient()
  return useMutation({
    mutationFn: (id: number) => deleteGrip(id),
    onSuccess: () => qc.invalidateQueries({ queryKey: ['grips'] }),
  })
}

export function useAssessments(gripId: number) {
  return useQuery({ queryKey: ['assessments', gripId], queryFn: () => getAssessments(gripId) })
}

export function useCreateAssessment() {
  const qc = useQueryClient()
  return useMutation({
    mutationFn: ({ gripId, data }: { gripId: number; data: { assessmentType: string; customName?: string } }) =>
      createAssessment(gripId, data),
    onSuccess: (_, { gripId }) => qc.invalidateQueries({ queryKey: ['assessments', gripId] }),
  })
}

export function useAddAssessmentEntry() {
  const qc = useQueryClient()
  return useMutation({
    mutationFn: ({ gripId, assessmentId, data }: { gripId: number; assessmentId: number; data: Record<string, number | null> }) =>
      addAssessmentEntry(gripId, assessmentId, data),
    onSuccess: (_, { gripId }) => qc.invalidateQueries({ queryKey: ['assessments', gripId] }),
  })
}
